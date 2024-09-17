package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment
import scala.util.Random
import scala.concurrent.duration._

object SpecialInterventions {

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
      )

    // .exec {
    //   session =>
    //     println(session("caseId").as[String])
    //     session
    // }

    .pause(600.seconds)

  val RequestHearing = 

    exec(http("SI_030_AddHearing_GetToken")
      .get(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/event-triggers/addHearing/token")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .check(jsonPath("$.token").saveAs("eventToken")))

    .exec(http("SI_030_AddHearing_CreateEvent")
      .post(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/events")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .body(ElFileBody("bodies/bodies/CCD_RequestHearing.json")))

    .pause(Environment.constantthinkTime.seconds)

  val HearingBooked =

    exec(http("SI_040_HearingBooked_GetToken")
      .get(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/event-triggers/hearingBooked/token")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .check(jsonPath("$.token").saveAs("eventToken")))

    .exec(http("SI_040_HearingBooked_CreateEvent")
      .post(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/events")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .body(ElFileBody("bodies/bodies/HearingBooked.json")))

    .pause(Environment.constantthinkTime.seconds)

  val RequestHearingResponse = 

    exec(http("SI_020_UploadResponse_GetToken")
      .get(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/event-triggers/dwpUploadResponse/token")
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

    .exec(http("SI_020_AddHearing_CreateEvent")
      .post(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/events")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .body(ElFileBody("bodies/bodies/UploadResponse.json")))

    .pause(300)

  val WriteFinalDecision =

    exec(http("SI_050_WriteFinalDecision_GetToken")
      .get(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/event-triggers/writeFinalDecision/token")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .check(jsonPath("$.token").saveAs("eventToken")))

    .exec(http("SI_050_WriteFinalDecision_CreateEvent")
      .post(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/events")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .body(ElFileBody("bodies/bodies/WriteFinalDecision.json")))

    .pause(Environment.constantthinkTime.seconds)

  val IssueFinalDecision =

    exec(http("SI_060_IssueFinalDecision_GetToken")
      .get(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/event-triggers/issueFinalDecision/token")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .check(jsonPath("$.token").saveAs("eventToken")))

    .exec(http("SI_060_IssueFinalDecision_CreateEvent")
      .post(Environment.ccdDataStoreUrl + "/caseworkers/a91aa146-2396-490d-9a27-6c2a3031f994/jurisdictions/SSCS/case-types/Benefit/cases/#{caseId}/events")
      .header("ServiceAuthorization", "Bearer #{ccd_dataBearerToken}")
      .header("Authorization", "Bearer #{accessToken}")
      .header("Content-Type","application/json")
      .body(ElFileBody("bodies/bodies/IssueFinalDecision.json")))

    .exec {
      session =>
        println(session("caseId").as[String])
        session
    }

      



}