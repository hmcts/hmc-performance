package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

	/*===============================================================================================
	* Updates a Single Hearing
    * Updated Hearing for a Case.  Response is provided by HMI and LA
    * Header - Bearer Token is required and s2s token for hmc_hmi_inbound_adapter
    * Data - UpdateHearing.csv
	 ===============================================================================================*/

object UpdateHearing {

  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime

  val UpdateHearing = group("020_update_request_hearings") {
    exec(http(requestName="put_update_hearings")
      .put("/hearing/${hearingref2}")
      .headers(Environment.commonHeader)
      .body(ElFileBody("bodies/bodies/UpdateHearing.json")).asJson
      .check(status.is(201))
      .check(bodyString.saveAs("BODY2")))
    .exec{
      session =>
        println(session("BODY2").as[String])
        session
    }
    .pause(MinThinkTime , MaxThinkTime)
    }
}
