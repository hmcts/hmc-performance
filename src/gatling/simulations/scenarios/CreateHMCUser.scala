package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment
import java.io.{BufferedWriter, FileWriter}

	/*===============================================================================================
	* Creates a new HMC User in IDAM
	* Uses a basic header where no Auth is required
	* HMCUsers.csv contains the Users and password to be setup
	* once the users have been created they are written to HMCUserDetails.csv with their IDAM ID and Username
	 ===============================================================================================*/

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
