package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.RequestHearing
import utils.{Environment, IDAMHelper, S2SHelper}



  class HMIPTSimulation extends Simulation
  {

    val RequestHearingData1= csv("RequestHearingData1.csv").circular
    val RequestHearingData2= csv("RequestHearingData2.csv").circular
    val RequestHearingData3= csv("RequestHearingData3.csv").circular

    val httpProtocol = http.baseUrl (url = Environment.baseURL)
    val BashURL = Environment.baseURL
   // val httpProtocol = http
      //.baseUrl(BashURL)
    // .proxy(Proxy("proxyout.reform.hmcts.net", 8080))

    val RH = scenario("RequestHearing").feed(RequestHearingData1)
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
