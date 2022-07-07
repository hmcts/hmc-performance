package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

	/*===============================================================================================
	* Updates a Single Hearing
	 ===============================================================================================*/

object UpdateHearing {

  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime

  val UpdateHearing = scenario(scenarioName = "020_UpdateHearing_Post")
    .group("010_post_request_hearings") {
    exec(http(requestName="put_update_hearings")
      .put("/hearing/${hearingref}")
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
