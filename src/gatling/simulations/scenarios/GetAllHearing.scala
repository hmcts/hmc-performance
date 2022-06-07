package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

//This gets all hearings for a case.  if a status is provided it returns all cases for that hearing which meet the status requirements

object GetAllHearing {

  val GetAllHearing = scenario(scenarioName = "050_GetHearing_get")
    .group("050_GetAllHearings") {
      exec(http(requestName = "get_all_hearing")
        .get("/hearings/${caseref2}?status=HEARING_REQUESTED")
        .headers(Environment.commonHeader)
        .check(status.is(200))
        .check(bodyString.saveAs("BODY5")))
        .exec {
          session =>
            println(session("BODY5").as[String])
            session
        }
    }
}
