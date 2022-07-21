package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.{DeleteHearing, GetAllHearing, GetHearing, RequestHearing, UpdateHearing, RequestHearingResponse,CreateHMCUser,UserAssignment,CreateAppealCase}
import utils.{Environment, IDAMHelper, S2SHelper}



  class HMCPTSimulation extends Simulation
  {

	/*===============================================================================================
	* Data Files used for Simlations
	 ===============================================================================================*/

    val NINumberFeeder = csv("bodies/bodies/NINumber.csv").circular
    val HMCUsersFeeder = csv("bodies/bodies/HMCUsers.csv").circular
    val HMCIDAMUsersFeeder = csv("bodies/bodies/HMCUsersIDAMID.csv").circular
    val requesthearingFeeder = csv("bodies/bodies/RequestHearing.csv").circular
    val hearingFeeder = csv("bodies/bodies/Hearing.csv").circular
    val updatehearingFeeder = csv("bodies/bodies/UpdateHearing.csv").circular

    val httpProtocol = http.baseUrl (url = Environment.baseURL)
    val BashURL = Environment.baseURL
   // val httpProtocol = http
      //.baseUrl(BashURL)
    // .proxy(Proxy("proxyout.reform.hmcts.net", 8080))


	/*===============================================================================================
	* Requests a Hearing simulation
	* RequestHearingFeeder - CSV provides data for Request Hearing
	* RequestHearingFeeder - CSV provides data for Request Hearing
	 ===============================================================================================*/

    //This scenario Requests hearing, View All Hearing and Views a Hearing
    val RH = scenario("RequestHearing")
      .feed(requesthearingFeeder)
      .feed(hearingFeeder)
      .repeat(1){
      exitBlockOnFail
      {
      exec(
       S2SHelper.S2SAuthToken,
    // IDAMHelper.getIdamToken,
       GetHearing.GetHearing,
       GetAllHearing.GetAllHearing,
       RequestHearing.RequestHearing,
       GetHearing.GetHearing,
       GetAllHearing.GetAllHearing
       )
       }
    }


    //This scenario Update and Delete Hearing and within each action it Views all hearing and views a single hearing

    val RUDH = scenario("RequestUpdateDeleteHearing")
      .feed(updatehearingFeeder)
      .exitBlockOnFail
      {
        exec(
          S2SHelper.S2SAuthToken,
          //  IDAMHelper.getIdamToken,
         GetHearing.GetHearing,
       //   GetAllHearing.GetAllHearing,
          UpdateHearing.UpdateHearing,
        //  GetHearing.GetHearing,
         // GetAllHearing.GetAllHearing,
         // DeleteHearing.DeleteHearing,
          GetHearing.GetHearing,
        //  GetAllHearing.GetAllHearing
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
          GetAllHearing.GetAllHearing,
          GetHearing.GetHearing
        )
      }

    //This scenario Views all hearing and views single hearing
    val RHR = scenario("RequestHearingResponse")
      .feed(hearingFeeder)
      .exitBlockOnFail
      {
        exec(
          S2SHelper.S2SAuthToken,
          //  IDAMHelper.getIdamToken,
          RequestHearingResponse.RequestHearingResponse
        )
      }


    //CreateUser
    val CreateUser = scenario("CreateUser")
     .repeat(1){
     feed(HMCUsersFeeder)
     .exec(
         CreateHMCUser.CreateHMCUser
        )
      }

    //CreateUser
    val UserAssignments = scenario("CreateUser")
     .repeat(1){
     feed(HMCIDAMUsersFeeder)
     .exec(
         S2SHelper.S2SAuthToken,
         UserAssignment.UserAssignment
        )
      }

    //CreateAppealCase
    val CreateAppeal= scenario("CreateAppeal")
     .repeat(10){
     feed(NINumberFeeder)
     .exec(
         CreateAppealCase.CreateAppealCase
        )
      }

    //Smoke Tests
  setUp(RH.inject(rampUsers(1).during(1)))
     .protocols(httpProtocol)
    .maxDuration(7600)

}

