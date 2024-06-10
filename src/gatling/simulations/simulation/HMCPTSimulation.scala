package simulation

import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.commons.stats.assertion.Assertion
import io.gatling.core.pause.PauseType
import scala.concurrent.duration._
import io.gatling.core.controller.inject.open.{AtOnceOpenInjection, OpenInjectionStep}
import scenarios._
import utils._

class HMCPTSimulation extends Simulation {

  /* TEST TYPE DEFINITION */
	/* pipeline = nightly pipeline against the AAT environment (see the Jenkins_nightly file) */
	/* perftest (default) = performance test against the perftest environment */
	val testType = scala.util.Properties.envOrElse("TEST_TYPE", "perftest")

	//set the environment based on the test type
	val environment = testType match{
		case "perftest" => "perftest"
		case "pipeline" => "aat"
		case _ => "**INVALID**"
	}

	/* ******************************** */
	/* ADDITIONAL COMMAND LINE ARGUMENT OPTIONS */
	val debugMode = System.getProperty("debug", "off") //runs a single user e.g. ./gradlew gatlingRun -Ddebug=on (default: off)
	val env = System.getProperty("env", environment) //manually override the environment aat|perftest e.g. ./gradlew gatlingRun -Denv=aat
	/* ******************************** */

  /* PERFORMANCE TEST CONFIGURATION */
	val specialInterventionsTarget:Double = 95 //95

	val rampUpDurationMins = 5
	val rampDownDurationMins = 5
	val testDurationMins = 60 // 60

	val numberOfPipelineUsers = 5
	val pipelinePausesMillis:Long = 3000 //3 seconds

	//Determine the pause pattern to use:
	//Performance test = use the pauses defined in the scripts
	//Pipeline = override pauses in the script with a fixed value (pipelinePauseMillis)
	//Debug mode = disable all pauses
	val pauseOption:PauseType = debugMode match{
		case "off" if testType == "perftest" => constantPauses
		case "off" if testType == "pipeline" => customPauses(pipelinePausesMillis)
		case _ => constantPauses //disabledPauses
	}

  val httpProtocol = Environment.HttpProtocol
    .baseUrl(Environment.baseURL.replace("#{env}", s"${env}"))
    .doNotTrackHeader("1")

  val SpecialInterventionSimulation = scenario("Special Interventions")
    .exitBlockOnFail {
      exec(_.set("env", s"${env}"))
      .exec(S2SHelper.s2s("ccd_data"))
      .exec(IDAMHelper.GetIdamTokenSI)
      .exec(SpecialInterventions.CreateAppeal)
      .exec(SpecialInterventions.RequestHearingResponse)
      .exec(SpecialInterventions.RequestHearing)
      .exec(SpecialInterventions.HearingBooked)
      .exec(SpecialInterventions.WriteFinalDecision)
      .exec(SpecialInterventions.IssueFinalDecision)
    }

  def simulationProfile(simulationType: String, userPerHourRate: Double, numberOfPipelineUsers: Double): Seq[OpenInjectionStep] = {
		val userPerSecRate = userPerHourRate / 3600
		simulationType match {
			case "perftest" =>
				if (debugMode == "off") {
					Seq(
						rampUsersPerSec(0.00) to (userPerSecRate) during (rampUpDurationMins.minutes),
						constantUsersPerSec(userPerSecRate) during (testDurationMins.minutes),
						rampUsersPerSec(userPerSecRate) to (0.00) during (rampDownDurationMins.minutes)
					)
				}
				else{
					Seq(atOnceUsers(1))
				}
			case "pipeline" =>
				Seq(rampUsers(numberOfPipelineUsers.toInt) during (2.minutes))
			case _ =>
				Seq(nothingFor(0))
		}
	}

  //defines the test assertions, based on the test type
  def assertions(simulationType: String): Seq[Assertion] = {
    simulationType match {
      case "perftest" =>
        if (debugMode == "off") {
          Seq(global.successfulRequests.percent.gte(95)
          )
        }
        else{
          Seq(global.successfulRequests.percent.gte(95)
          )
        }
      case "pipeline" =>
        Seq(global.successfulRequests.percent.gte(95),
            forAll.successfulRequests.percent.gte(90)
        )
      case _ =>
        Seq()
    }
  }

      
  setUp(
    SpecialInterventionSimulation.inject(simulationProfile(testType, specialInterventionsTarget, numberOfPipelineUsers)).pauses(pauseOption)
  )
  .protocols(httpProtocol)
  .assertions(assertions(testType))
  // .maxDuration(85)

}

