package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment



object RequestHearing {

  val RequestHearing = scenario(scenarioName = "010_RequestHearing_Post")
    .exec(http(requestName="post_request_hearings")
      .post("/hearings/")
      .headers(Environment.commonHeader)
      .body(ElFileBody("bodies/RequestHearing.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY1")))
    .exec{
      session =>
        println(session("BODY1").as[String])
        session
    }
}
