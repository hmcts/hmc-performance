package simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.{DeleteHearing, GetAllHearing, GetHearing, RequestHearing, UpdateHearing, RequestHearingResponse,CreateHMCUser,UserAssignment,CreateAppealCase,IACRequestHearingResponse}
import utils.{Environment, IDAMHelper, S2SHelper}



  class HMCPTSimulation extends Simulation
  {

	/*===============================================================================================
	* Data Files used for Simulations
	 ===============================================================================================*/

    val NINumberFeeder = csv("bodies/bodies/NINumber.csv").circular
    val HMCUsersFeeder = csv("bodies/bodies/HMCUsers.csv").circular
    val HMCIDAMUsersFeeder = csv("bodies/bodies/HMCUsersIDAMID.csv").circular
    val requesthearingFeeder = csv("bodies/bodies/RequestHearing.csv").circular
    val hearingFeeder = csv("bodies/bodies/Hearing.csv").circular
    val updatehearingFeeder = csv("bodies/bodies/UpdateHearing.csv").circular
    val deletehearingFeeder = csv("bodies/bodies/DeleteHearing.csv").circular
    val CivilResponsehearingFeeder = csv("bodies/bodies/CivilRequestHearingResponse.csv").circular
    val IACResponsehearingFeeder = csv("bodies/bodies/IACRequestHearingResponse.csv").circular

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
    //  exitBlockOnFail
  //    {
      exec(
      S2SHelper.S2SAuthToken,
      // IDAMHelper.getIdamToken,
      repeat(1){
      exec(
      GetHearing.GetHearing,
      GetAllHearing.GetAllHearing,
      RequestHearing.RequestHearing
   //   GetHearing.GetHearing,
   //   GetAllHearing.GetAllHearing
      )
       }
       )
   // }
    }


    //This scenario Update and Delete Hearing and within each action it Views all hearing and views a single hearing

    val RUDH = scenario("RequestUpdateDeleteHearing")
      .feed(updatehearingFeeder)
      .feed(deletehearingFeeder)
     // .exitBlockOnFail
    //  {
        .exec(
          S2SHelper.S2SAuthToken,
          //  IDAMHelper.getIdamToken,
         repeat(1){
         exec(
       //  GetHearing.GetHearing,
      //   GetAllHearing.GetAllHearing,
         UpdateHearing.UpdateHearing,
      //   GetHearing.GetHearing,
      //   GetAllHearing.GetAllHearing,
         pause(60),
         DeleteHearing.DeleteHearing,
         GetHearing.GetHearing,
         GetAllHearing.GetAllHearing
         )
         }
        )
   //   }

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
      .feed(CivilResponsehearingFeeder)
      .exitBlockOnFail
      {
        exec(
          S2SHelper.S2SAuthToken,
          //  IDAMHelper.getIdamToken,
          RequestHearingResponse.RequestHearingResponse
        )
      }

    //This scenario Views all hearing and views single hearing
    val IACRHR = scenario("IACRequestHearingResponse")
      .feed(IACResponsehearingFeeder)
      .exitBlockOnFail
      {
        exec(
          S2SHelper.S2SAuthToken,
          //  IDAMHelper.getIdamToken,
          IACRequestHearingResponse.IACRequestHearingResponse
        )
      }


    //CreateUser
    val CreateUser = scenario("CreateUser")
     .repeat(100){
     feed(HMCUsersFeeder)
     .exec(
         CreateHMCUser.CreateHMCUser
        )
      }

    //CreateUser
    val UserAssignments = scenario("CreateUser")
     .repeat(100){
     feed(HMCIDAMUsersFeeder)
     .exec(
         S2SHelper.S2SAuthToken,
         UserAssignment.UserAssignment
        )
      }

    //CreateAppealCase
    val CreateAppeal= scenario("CreateAppeal")
     .repeat(1700){
     feed(NINumberFeeder)
     .exec(
         CreateAppealCase.CreateAppealCase,
         pause(2)
        )
      }



    //Smoke Tests
 /* setUp(CreateAppeal.inject(rampUsers(1).during(1)))
     .protocols(httpProtocol)
   .maxDuration(30000)
*/
    //Request Hearing Smoke Tests
//  setUp(RH.inject(rampUsers(400).during(800)))
  //(RUDH.inject(rampUsers(1).during(1))))
  //  .protocols(httpProtocol)
   // .maxDuration(3600)



//    CIVIL HMC Request Hearing Peak/Stress Test
  /*setUp(
    (RH.inject(rampUsers(1700).during(3300))),  //1700 3300
    (RUDH.inject(rampUsers(250).during(3200))), //250 3200
   (CreateAppeal.inject(rampUsers(1).during(100))))//1
     .protocols(httpProtocol)
    .maxDuration(4000)
   */

    //    CIVIL HMC Request Hearing Stress Test
  setUp(
    (RH.inject(rampUsers(3400).during(3300))),  //1700 3300
    (RUDH.inject(rampUsers(500).during(3200))), //250 3200
   (CreateAppeal.inject(rampUsers(1).during(100))))//1
     .protocols(httpProtocol)
    .maxDuration(4000)


    //Request Hearing Smoke Tests
 /* setUp(RH.inject(rampUsers(1700).during(3400)),  //1700 3400
    (RUDH.inject(rampUsers(250).during(3200))), //250 3200
  (CreateAppeal.inject(rampUsers(1).during(1)))) //1
     .protocols(httpProtocol)
     .maxDuration(4000)
*/

/*
     setUp(RHR.inject(rampUsers(1577).during(2400)))
         .protocols(httpProtocol)
      .maxDuration(30000)
*/

    /*
    setUp(IACRHR.inject(rampUsers(50).during(300)))
      .protocols(httpProtocol)
      .maxDuration(30000)
*/


//Soak test
// RH 4400 / 14200
//RUDH 660 /14200
//14600
}

