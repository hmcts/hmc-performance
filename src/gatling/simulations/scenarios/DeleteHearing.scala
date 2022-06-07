package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

//This Deletes a single existing hearing.  The hearing needs to be in the following status (TBC) so that you can delete it


object DeleteHearing {

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
    }
}
