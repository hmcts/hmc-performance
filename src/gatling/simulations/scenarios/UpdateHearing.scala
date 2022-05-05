package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment


object UpdateHearing {

  val UpdateHearing = scenario(scenarioName = "020_UpdateHearing_Post")
    .exec(http(requestName="put_update_hearings")
      .put("/hearings/2000000062")
      .headers(Environment.commonHeader)
      .body(ElFileBody("bodies/UpdateHearing.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY2")))
    .exec{
      session =>
        println(session("BODY2").as[String])
        session
    }
}
