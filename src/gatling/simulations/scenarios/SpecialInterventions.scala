package scenarios


import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment
import java.io.{BufferedWriter, FileWriter}

object SpecialInterventions {


/* 

1. Create Appeal using existing create payload

2. Send to FTA - check XUI repo, check which request with Jack?

3. Request Hearing

4. Request Hearing Response - check if payload is still valid, if not check with Gokul

*/

  val CreateAppeal = 

    exec(http(requestName="SI_010_CreateAppealCase")
      .post("http://sscs-tribunals-api-perftest.service.core-compute-perftest.internal/appeals")
    
      .body(ElFileBody("bodies/bodies/CreateAppealCase.json")).asJson
      .check(status.is(201))
      .check(header("Location").optional.saveAs("Location"))
      // .check(bodyString.saveAs("BODY10"))
      )

    
  val SendToFTA =

    //TBC

  val RequestHearing = 

    exec(http("SI_010_RequestHearing")
      .post("http://hmc-cft-hearing-service-perftest.service.core-compute-perftest.internal/hearing/")
      .headers(Environment.commonHeader)
      .body(ElFileBody("bodies/bodies/RequestHearing.json")).asJson
      .check(status.is(201))
      .check (regex ("\"status\":").saveAs ("hearingstatus"))
      .check(jsonPath("$..hearingRequestID").optional.saveAs("hearingRequestID"))
      .check(jsonPath("$..status").optional.saveAs("status"))
      .check(jsonPath("$..timeStamp").optional.saveAs("timeStamp"))
      .check(jsonPath("$..versionNumber").optional.saveAs("versionNumber"))
      // .check(bodyString.saveAs("BODY1"))
      )

  val RequestHearingResponse = 

    exec(http("put_request_hearings_response")
      .put("https://hmi-apim.perftest.platform.hmcts.net/hmi/hearings/${CivilHearingID}?")
      .headers(Environment.inboundcommonHeader)
      .body(ElFileBody("bodies/bodies/RequestHearingResponse.json")).asJson
      .check(status.is(202))
      )
      



}