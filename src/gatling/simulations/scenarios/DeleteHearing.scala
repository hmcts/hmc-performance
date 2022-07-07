package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

	/*===============================================================================================
	* Deletes a Single Hearing
	 ===============================================================================================*/


object DeleteHearing {

  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime

  val DeleteHearing = scenario(scenarioName = "030_DeleteHearing_delete")
    .group("030_DeleteHearing") {
      exec(http(requestName = "post_request_hearings")
        .delete("/hearing/${hearingref}")
        .headers(Environment.commonHeader)
        .body(ElFileBody("bodies/bodies/DeleteHearing.json")).asJson
        .check(status.is(202))
        .check(bodyString.saveAs("BODY3")))
        .exec {
          session =>
            println(session("BODY3").as[String])
            session
        }
    .pause(MinThinkTime , MaxThinkTime)
    }
}
