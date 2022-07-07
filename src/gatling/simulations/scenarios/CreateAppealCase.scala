package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment
import java.io.{BufferedWriter, FileWriter}

	/*===============================================================================================
	* Creates HMC User in IDAM
	 ===============================================================================================*/

object CreateAppealCase {

  val CreateAppealCase = scenario(scenarioName = "901_CreateUser_Post")
    .group("903_CreateAppealCase_Post") {
    exec(http(requestName="CreateAppealCase")
      .post("http://sscs-tribunals-api-perftest.service.core-compute-perftest.internal/appeals")
     // .headers(Environment.basicHeader)
      .body(ElFileBody("bodies/bodies/CreateAppealCase.json")).asJson
      .check(status.is(201))
     // .check(jsonPath("$..id").optional.saveAs("IDAMID"))
      //.check(jsonPath("$..email").optional.saveAs("Email"))
      .check(bodyString.saveAs("BODY10")))
    .exec {
      session =>
        println(session("BODY10").as[String])
        session
    }
     /*   .exec { session =>
          val fw = new BufferedWriter(new FileWriter("HMCAppeals.csv", true))
          try {
            fw.write(session("BODY10").as[String] + "\r\n")
          } finally fw.close()
          session
        }*/
    }
}
