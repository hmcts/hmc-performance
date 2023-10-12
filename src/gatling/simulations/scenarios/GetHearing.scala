package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment


	/*===============================================================================================
	* Get details for a Single Hearing ID
	* Get Hearing for a Case.  Response is provided by HMC
    * Header - Bearer Token is required and s2s token for hmc_hmi_inbound_adapter
    * Data - hearing.csv
	 ===============================================================================================*/


object GetHearing {

  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime

  val GetHearing = group("040_GetHearing") {
      exec(http(requestName = "get_hearing")
        .get("/hearing/${hearingref2}")
        .headers(Environment.commonHeader)
        .check(status.is(200))
        .check(bodyString.saveAs("BODY4")))
        .exec {
          session =>
            println(session("BODY4").as[String])
            session
        }
    .pause(MinThinkTime , MaxThinkTime)
    }
}
