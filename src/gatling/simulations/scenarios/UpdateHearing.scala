package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment

//This updates an existing hearing.  the hearing must be in the following states (TBC) in order for you to be able to update it

object UpdateHearing {

  val UpdateHearing = scenario(scenarioName = "020_UpdateHearing_Post")
    .exec(http(requestName="put_update_hearings")
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
}
