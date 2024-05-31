package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios._
import utils.{Environment, IDAMHelper, S2SHelper}

class HMCPTSimulation extends Simulation {

    /*===============================================================================================
    * Data Files used for Simulations
    ===============================================================================================*/

    val httpProtocol = http.baseUrl (url = Environment.baseURL)

    val SpecialInterventionSimulation = scenario("Special Interventions")
      .exec(SpecialInterventions.CreateAppeal)
      .exec(SpecialInterventions.SendToFTA)
      .exec(SpecialInterventions.RequestHearing)
      .exec(SpecialInterventions.RequestHearingResponse)

    setUp(
      (RSpecialInterventionSimulationH.inject(rampUsers(1).during(10))))
    .protocols(httpProtocol)
    // .maxDuration(85)

}

