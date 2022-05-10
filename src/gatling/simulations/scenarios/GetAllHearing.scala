package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment


object GetAllHearing {

  val GetHearing = scenario(scenarioName = "050_GetHearing_get")
    .exec(http(requestName="get_hearing")
      .get("hearings/1641911514704411?status=HEARING_REQUESTED")
      .headers(Environment.commonHeader)
      .check(status.is(202))
      .check(bodyString.saveAs("BODY5")))
    .exec{
      session =>
        println(session("BODY5").as[String])
        session
    }
}
