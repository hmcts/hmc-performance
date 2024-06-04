package utils

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment._

object  S2SHelper {

 val thinktime = 5


 val S2SAuthToken =

  exec(http("020_GetServiceToken")
    .post(S2S_BASE_URI + "/lease")
    .header("Content-Type", "application/json")
    .body(StringBody(
     s"""{
       "microservice": "${S2S_SERVICE_NAME}"
        }"""
    )).asJson
    .check(bodyString.saveAs("s2sToken"))
    .check(bodyString.saveAs("responseBody")))
    .pause(10)
 .exec( session => {
   println("the code of id is "+session("s2sToken").as[String])
   session
 })

    .pause(1)


  def s2s(microservice: String) = {

    exec(http("GetS2SToken")
      .post(S2S_BASE_URI + "/lease")
      .header("Content-Type", "application/json")
      .body(StringBody(s"""{"microservice":"${microservice}"}"""))
      .check(bodyString.saveAs(s"${microservice}BearerToken")))
      .exitHereIfFailed
  }





}
