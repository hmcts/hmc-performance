package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

//This gets a single existing hearing.


object GetHearing {

  val GetHearing = scenario(scenarioName = "040_GetHearing_get")
    .group("040_GetHearing") {
      .exec(http(requestName = "get_hearing")
        .get("/hearing/${hearingref}")
        .headers(Environment.commonHeader)
        .check(status.is(200))
        .check(bodyString.saveAs("BODY4")))
        .exec {
          session =>
            println(session("BODY4").as[String])
            session
        }
    }
}
