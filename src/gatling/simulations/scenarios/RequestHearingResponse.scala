package scenarios

import java.io.{BufferedWriter, FileWriter}

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

//HCM Hearing Request Response API which aims to mimic the response from HMI back to HMC after the hearing has been listed

	/*===============================================================================================
	* Requests a Hearing for a Case.  Response is provided by HMC
	* Hearing response details are saved to - HearingDetails.csv - This data is then used to feed
	 ===============================================================================================*/


object RequestHearingResponse {

  val RequestHearingResponse = group("060_post_request_hearings_response") {
    exec(http("put_request_hearings_response")
      .put("https://hmi-apim.demo.platform.hmcts.net/hmi/hearings/${CivilHearingID}?")
      .headers(Environment.inboundcommonHeader)
      .body(ElFileBody("bodies/bodies/RequestHearingResponse.json")).asJson
      .check(status.is(202))
      //.check (regex ("\"hearingRequestID\":(.*?)").saveAs ("hearingRequestID"))
      //.check (regex ("\"status\":").saveAs ("hearingstatus"))
      //.check(jsonPath("$..hearingRequestID").optional.saveAs("hearingRequestID"))
      //.check(jsonPath("$..status").optional.saveAs("status"))
      //.check(jsonPath("$..timeStamp").optional.saveAs("timeStamp"))
      //.check(jsonPath("$..versionNumber").optional.saveAs("versionNumber"))
        .check(bodyString.saveAs("BODY1")))
    .exec {
      session =>
        println(session("BODY1").as[String])
        session
    }
  }
}