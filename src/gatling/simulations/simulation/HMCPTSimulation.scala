package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.{Environment, IDAMHelper, S2SHelper}



  class HMCPTSimulation extends Simulation
  {


    val httpProtocol = http.baseUrl (url = Environment.baseURL)
    val BashURL = Environment.baseURL
   // val httpProtocol = http
      //.baseUrl(BashURL)
    // .proxy(Proxy("proxyout.reform.hmcts.net", 8080))

    val RH = scenario("RequestHearing")
      .exec(
        S2SHelper.S2SAuthToken,
        IDAMHelper.getIdamToken
       // RequestHearing.RequestHearing,
      )


    //Smoke Tests
  setUp(RH.inject(atOnceUsers(users = 1)))
     .protocols(httpProtocol)
    .maxDuration(1200)

}
