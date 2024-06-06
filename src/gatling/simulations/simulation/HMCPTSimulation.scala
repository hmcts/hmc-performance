package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.commons.stats.assertion.Assertion
import io.gatling.core.pause.PauseType
import scala.concurrent.duration._
import scenarios._
import utils._

class HMCPTSimulation extends Simulation {

    /*===============================================================================================
    * Data Files used for Simulations
    ===============================================================================================*/

    val httpProtocol = http.baseUrl (url = Environment.baseURL)

    val SpecialInterventionSimulation = scenario("Special Interventions")
        .exec(S2SHelper.s2s("ccd_data"))
        .exec(IDAMHelper.GetIdamToken)
        .exec(SpecialInterventions.CreateAppeal)
        .exec(SpecialInterventions.RequestHearing)
        .exec(SpecialInterventions.RequestHearingResponse)

    setUp(
      (SpecialInterventionSimulation.inject(rampUsers(1).during(10))))
    .protocols(httpProtocol)
    // .maxDuration(85)

}

