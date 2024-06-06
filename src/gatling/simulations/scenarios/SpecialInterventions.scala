package scenarios


import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment
import scala.util.Random
import scala.concurrent.duration._


object SpecialInterventions {


/* 

1. Create Appeal using existing create payload

2. Send to FTA - check XUI repo, check which request with Jack?

3. Request Hearing

4. Request Hearing Response - check if payload is still valid, if not check with Gokul

*/
  private val rng: Random = new Random()
  private def NINumber(): String = rng.alphanumeric.filter(_.isDigit).take(8).mkString
  private def firstName(): String = rng.alphanumeric.filter(_.isLetter).take(10).mkString
  private def lastName(): String = rng.alphanumeric.filter(_.isLetter).take(10).mkString

  val CreateAppeal = 

    exec(_.setAll(
        ("NINumber", NINumber()),
        ("firstname", firstName()),
        ("lastname", lastName())
    ))

    .exec(http(requestName="SI_010_CreateAppealCase")
      .post("http://sscs-tribunals-api-perftest.service.core-compute-perftest.internal/appeals")
      .body(ElFileBody("bodies/bodies/CreateValidAppeal.json")).asJson
      .check(status.is(201))
      .check(header("Location").optional.saveAs("Location"))
      .check(headerRegex("Location", "appeals/([0-9]+)").saveAs("caseId"))
      // .check(bodyString.saveAs("BODY10"))
      )

    // .exec(http("API_SSCS_GetEventToken")
    //   .get(Environment.ccdDataStoreUrl + "/caseworkers/546965/jurisdictions/SSCS/case-types/Benefit/event-triggers/validAppealCreated/token")
    //   .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
    //   .header("Authorization", "Bearer #{accessToken}")
    //   .header("Content-Type","application/json")
    //   .check(jsonPath("$.token").saveAs("eventToken")))

    // .exec(http("API_SSCS_CreateCase")
    //   .post(Environment.ccdDataStoreUrl + "/caseworkers/546965/jurisdictions/SSCS/case-types/Benefit/cases")
    //   .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
    //   .header("Authorization", "Bearer #{accessToken}")
    //   .header("Content-Type","application/json")
    //   .body(ElFileBody("bodies/bodies/CreateValidAppeal.json"))
    //   .check(jsonPath("$.id").saveAs("caseId")))

    .pause(Environment.constantthinkTime.seconds)

    .exec {
      session =>
        println(session("caseId").as[String])
        session
    }
    
  val SendToFTA =

    exec(http("SI_020_SendToFTA_GetToken")
      .get(Environment.ccdDataStoreUrl + "/caseworkers/546965/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/event-triggers/adminSendToWithDwp/token")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .check(jsonPath("$.token").saveAs("eventToken")))

    .exec(http("SI_020_SendToFTA_CreateEvent")
      .post(Environment.ccdDataStoreUrl + "/caseworkers/546965/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/events")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .body(ElFileBody("bodies/bodies/SendToFTA.json")))

    .pause(Environment.constantthinkTime.seconds)

  val RequestHearing = 

   exec(http("SI_030_AddHearing_GetToken")
      .get(Environment.ccdDataStoreUrl + "/caseworkers/546965/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/event-triggers/addHearing/token")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .check(jsonPath("$.token").saveAs("eventToken")))

    .exec(http("SI_030_AddHearing_CreateEvent")
      .post(Environment.ccdDataStoreUrl + "/caseworkers/546965/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/events")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .body(ElFileBody("bodies/bodies/CCD_RequestHearing.json")))

    .pause(Environment.constantthinkTime.seconds)


    //1717498801157254

  val RequestHearingResponse = 

    exec(http("SI_040_UploadResponse_GetToken")
      .get(Environment.ccdDataStoreUrl + "/caseworkers/546965/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/event-triggers/dwpUploadResponse/token")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .check(jsonPath("$.token").saveAs("eventToken"))
      .check(jsonPath("$.case_details.case_data.appeal.appellant.id").saveAs("appellantId"))
      .check(jsonPath("$.case_details.case_data.appeal.appellant.appointee.id").saveAs("appointeeId"))
      .check(jsonPath("$.case_details.case_data.appeal.appealReasons.reasons[0].id").saveAs("appealReason1"))
      .check(jsonPath("$.case_details.case_data.appeal.appealReasons.reasons[1].id").saveAs("appealReason2"))
      .check(jsonPath("$.case_details.case_data.appeal.appealReasons.reasons[2].id").saveAs("appealReason3"))
      .check(jsonPath("$.case_details.case_data.appeal.rep.id").saveAs("repId")))

    .exec(http("SI_030_AddHearing_CreateEvent")
      .post(Environment.ccdDataStoreUrl + "/caseworkers/546965/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/events")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .body(ElFileBody("bodies/bodies/UploadResponse.json")))

    .pause(Environment.constantthinkTime.seconds)
      



}