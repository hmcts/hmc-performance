package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment
import java.io.{BufferedWriter, FileWriter}

	/*===============================================================================================
	* Data Prep - Creates Appeals for HMC which can then be used to Create/Get/Amend/Delete Hearings
	* Single API Request - no auth is required
	* The created Appeals are then written to the HMCAppeals.csv
	* nino needs to be unique for each request in the CreateAppealCase.json.  This is currently fed
	* in viaNINumber.csv
	 ===============================================================================================*/

object CreateAppealCase {

  val CreateAppealCase = group("901_CreateAppeal_Post") {
    exec(http(requestName="CreateAppealCase")
      .post("http://sscs-tribunals-api-perftest.service.core-compute-perftest.internal/appeals")
     //.post("http://sscs-tribunals-api-aat.service.core-compute-aat.internal/appeals")
     // .headers(Environment.basicHeader)
      .body(ElFileBody("bodies/bodies/CreateAppealCase.json")).asJson
      .check(status.is(201))
      .check(header("Location").optional.saveAs("Location"))
      //.check(jsonPath("$..email").optional.saveAs("Email"))
      .check(bodyString.saveAs("BODY10")))
    .exec {
      session =>
        println(session("BODY10").as[String])
        session
    }
        .exec { session =>
          val fw = new BufferedWriter(new FileWriter("HMCAppeals2.csv", true))
          try {
           fw.write(session("Location").as[String] + "\r\n")
          } finally fw.close()
          session
        }
    }

}
