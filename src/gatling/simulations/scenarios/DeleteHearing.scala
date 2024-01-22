package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

	/*===============================================================================================
	* Deletes a Single Hearing
    * Updated Hearing for a Case.  Response is provided by HMI and LA
    * Header - Bearer Token is required and s2s token for hmc_hmi_inbound_adapter
    * Data - UpdateHearing.csv
	 ===============================================================================================*/


object DeleteHearing {

  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime

  val DeleteHearing = group("030_DeleteHearing") {
      exec(http(requestName = "delete_request_hearings")
        .delete("/hearing/${hearingref3}")
        .headers(Environment.commonHeader)
        .body(ElFileBody("bodies/bodies/DeleteHearing.json")).asJson
        .check(status.is(200))
        .check(bodyString.saveAs("BODY3")))
        .exec {
          session =>
            println(session("BODY3").as[String])
            session
        }
    .pause(MinThinkTime , MaxThinkTime)
    }
}
