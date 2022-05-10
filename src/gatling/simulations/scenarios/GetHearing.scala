package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment


object GetHearing {

  val GetHearing = scenario(scenarioName = "040_GetHearing_get")
    .exec(http(requestName="get_hearing")
      .get("/hearings/2000000062")
      .headers(Environment.commonHeader)
      .check(status.is(202))
      .check(bodyString.saveAs("BODY4")))
    .exec{
      session =>
        println(session("BODY4").as[String])
        session
    }
}
