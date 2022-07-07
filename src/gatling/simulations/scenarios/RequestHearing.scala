package scenarios

import java.io.{BufferedWriter, FileWriter}

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment


	/*===============================================================================================
	* Requests a Hearing for a Case.  Response is provided by HMC
	* Hearing response details are saved to - HearingDetails.csv - This data is then used to feed
	 ===============================================================================================*/

object RequestHearing {

  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime

  val RequestHearing = scenario(scenarioName = "010_RequestHearing_Post")
  .group("010_post_request_hearings") {
    exec(http("post_request_hearings")
      .post("/hearing/")
      .headers(Environment.commonHeader)
      .body(ElFileBody("bodies/bodies/RequestHearing.json")).asJson
      .check(status.is(201))
      //.check (regex ("\"hearingRequestID\":(.*?)").saveAs ("hearingRequestID"))
      .check (regex ("\"status\":").saveAs ("hearingstatus"))
      .check(jsonPath("$..hearingRequestID").optional.saveAs("hearingRequestID"))
      .check(jsonPath("$..status").optional.saveAs("status"))
      .check(jsonPath("$..timeStamp").optional.saveAs("timeStamp"))
      .check(jsonPath("$..versionNumber").optional.saveAs("versionNumber"))
      .check(bodyString.saveAs("BODY1")))
    .exec {
      session =>
        println(session("BODY1").as[String])
        session
    }
    .exec { session =>
      val fw = new BufferedWriter(new FileWriter("HearingDetails.csv", true))
      try {
        fw.write(session("CaseRef1").as[String] + "," + session("hearingRequestID").as[String] + "," + session("status").as[String] + "," + session("timeStamp").as[String]+ "," + session("versionNumber").as[String] + "\r\n")
      } finally fw.close()
      session
    }
    .pause(MinThinkTime , MaxThinkTime)

  }
}