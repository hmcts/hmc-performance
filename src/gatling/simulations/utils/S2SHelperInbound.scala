package utils

import com.warrenstrange.googleauth.GoogleAuthenticator
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment._

object  S2SHelperInbound {

 val thinktime = 5

 val getOTP =
  exec(
   session => {
    val otp: String = String.valueOf(new GoogleAuthenticator().getTotpPassword(FUNCTIONAL_TEST_CLIENT_S2S_TOKEN))
    session.set("OTP", otp)

   })

 val otpp="${OTP}"

 val S2SAuthToken2 =

  exec(http("020_GetServiceToken")
    .post(S2S_BASE_URI + "/lease")
    .header("Content-Type", "application/json")
    .body(StringBody(
     s"""{
       "microservice": "${S2S_SERVICE_NAME2}"
        }"""
    )).asJson
    .check(bodyString.saveAs("s2sToken2"))
    .check(bodyString.saveAs("responseBody")))
    .pause(10)
 .exec( session => {
   println("the code of id is "+session("s2sToken2").as[String])
   session
 })

    .pause(1)





}
