package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

	/*===============================================================================================
	* Get Details for all Hearings for a Case
    * Get Hearing for a Case.  Response is provided by HMC
    * Header - Bearer Token is required and s2s token for hmc_hmi_inbound_adapter
    * Data - hearing.csv
	 ===============================================================================================*/

object GetAllHearing {

  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime

  val GetAllHearing = group("050_GetAllHearings") {
      exec(http(requestName = "get_all_hearing")
        .get("/hearings/${caseref2}?")
        .headers(Environment.commonHeader)
        .check(status.is(200))
        .check(bodyString.saveAs("BODY5")))
        .exec {
          session =>
            println(session("BODY5").as[String])
            session
        }
    .pause(MinThinkTime , MaxThinkTime)
    }
}
