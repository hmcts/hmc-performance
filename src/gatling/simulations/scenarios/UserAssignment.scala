package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment
import java.io.{BufferedWriter, FileWriter}

	/*===============================================================================================
	* This sets up the user in Role Assignements with the Hearing credentials
	* Uses a common header which requires Bearer Token and s2s token for "am_role_assignment_service"
	* Data > copy output file  HMCUserDetails.csv to HMCUsersIDAMID.csv
	 ===============================================================================================*/


object UserAssignment {

  val UserAssignment = scenario(scenarioName = "902_UserAssignment_Post")
    .group("901_UserAssignment_Post") {
    exec(http(requestName="UserAssignment")
      .post("http://am-role-assignment-service-perftest.service.core-compute-perftest.internal/am/role-assignments")
      .headers(Environment.commonHeader)
      .body(ElFileBody("bodies/bodies/RoleAssignment.json")).asJson
      .check(status.is(201)))
   //   .check(bodyString.saveAs("BODY10")))
//    .exec {
  //    session =>
   //     println(session("BODY10").as[String])
  //      session
    //}
    }
}
