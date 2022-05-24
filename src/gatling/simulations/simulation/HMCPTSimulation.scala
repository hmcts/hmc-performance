package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.{DeleteHearing, GetAllHearing, GetHearing, RequestHearing, UpdateHearing}
import utils.{Environment, IDAMHelper, S2SHelper}



  class HMCPTSimulation extends Simulation
  {

    val requesthearingFeeder = csv("bodies/bodies/RequestHearing.csv").circular
    val hearingFeeder = csv("bodies/bodies/Hearing.csv").circular
    val updatehearingFeeder = csv("bodies/bodies/UpdateHearing.csv").circular

    val httpProtocol = http.baseUrl (url = Environment.baseURL)
    val BashURL = Environment.baseURL
   // val httpProtocol = http
      //.baseUrl(BashURL)
    // .proxy(Proxy("proxyout.reform.hmcts.net", 8080))


    //This scenario Requests hearing, View All Hearing and Views a Hearing
    val RH = scenario("RequestHearing")
      .feed(requesthearingFeeder)
      .feed(hearingFeeder)
      .exitBlockOnFail
      {
      exec(
       S2SHelper.S2SAuthToken,
        //  IDAMHelper.getIdamToken,
        GetHearing.GetHearing,
        GetAllHearing.GetAllHearing,
        RequestHearing.RequestHearing,
        GetHearing.GetHearing,
        GetAllHearing.GetAllHearing,
       )
    }


    //This scenario Update and Delete Hearing and within each action it Views all hearing and views a single hearing

    val RUDH = scenario("RequestUpdateDeleteHearing")
      .feed(requesthearingFeeder)
      .feed(updatehearingFeeder)
      .exitBlockOnFail
      {
        exec(
          S2SHelper.S2SAuthToken,
          //  IDAMHelper.getIdamToken,
          GetHearing.GetHearing,
          GetAllHearing.GetAllHearing,
          UpdateHearing.UpdateHearing,
          GetHearing.GetHearing,
          GetAllHearing.GetAllHearing,
          DeleteHearing.DeleteHearing,
          GetHearing.GetHearing,
          GetAllHearing.GetAllHearing
        )
      }

// This scenarios Gets a Hearing and Gets all hearings
    val GH = scenario("GetHearing")
      .feed(hearingFeeder)
      .exitBlockOnFail
      {
        exec(
          S2SHelper.S2SAuthToken,
          //  IDAMHelper.getIdamToken,
          GetHearing.GetHearing,
          GetAllHearing.GetAllHearing,
        )
      }

    //This scenario Views all hearing and views single hearing




    //Smoke Tests
  setUp(GH.inject(atOnceUsers(users = 1)))
     .protocols(httpProtocol)
    .maxDuration(1200)

}
