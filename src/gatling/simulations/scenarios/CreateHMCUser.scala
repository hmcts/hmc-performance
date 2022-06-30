package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment
import java.io.{BufferedWriter, FileWriter}

//This updates an existing hearing.  the hearing must be in the following states (TBC) in order for you to be able to update it

object CreateHMCUser {

  val CreateHMCUser = scenario(scenarioName = "901_CreateUser_Post")
    .group("901_CreateUser_Post") {
    exec(http(requestName="CreateUser")
      .post("https://idam-api.perftest.platform.hmcts.net/testing-support/accounts")
      .headers(Environment.basicHeader)
      .body(ElFileBody("bodies/bodies/CreateHMCUser.json")).asJson
      .check(status.is(201))
      .check(jsonPath("$..id").optional.saveAs("IDAMID"))
      .check(jsonPath("$..email").optional.saveAs("Email"))
      .check(bodyString.saveAs("BODY10")))
    .exec {
      session =>
        println(session("BODY10").as[String])
        session
    }
    .exec { session =>
      val fw = new BufferedWriter(new FileWriter("HMCUserDetails.csv", true))
      try {
        fw.write(session("IDAMID").as[String] + "," + session("Email").as[String] + "\r\n")
      } finally fw.close()
      session
    }
    }
}