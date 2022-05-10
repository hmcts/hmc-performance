package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment


object DeleteHearing {

  val RequestHearing = scenario(scenarioName = "030_DeleteHearing_delete")
    .exec(http(requestName="post_request_hearings")
      .delete("/hearings/2000000062")
      .headers(Environment.commonHeader)
      .body(ElFileBody("bodies/DeleteHearing.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY3")))
    .exec{
      session =>
        println(session("BODY3").as[String])
        session
    }
}
