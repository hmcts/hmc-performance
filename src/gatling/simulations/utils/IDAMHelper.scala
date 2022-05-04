package utils

import utils.Environment._
import io.gatling.core.Predef._
import io.gatling.http.Predef._


object S2SHelper {
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
}