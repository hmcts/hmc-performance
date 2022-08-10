package utils

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment._

object  IDAMHelper {

    private val USERNAME = "sscsHearing_manager501@justice.gov.uk"
    private val PASSWORD = "Password12"


    val thinktime = Environment.minThinkTime

    val getIdamToken =
      exec(http("010_GetAuthToken")
        .post(idamURL  + "/o/token?client_id=" + OAUTH_CLIENT + "&client_secret=" + IDAM_OAUTH_SECRET + "&grant_type=password&scope=openid profile roles search-user&username=sscsHearing_manager501@justice.gov.uk&password=Password12")
        .header("Content-Type", "application/x-www-form-urlencoded")
        .header("Content-Length", "0")
        .check(status is 200)
        .check(jsonPath("$.access_token").saveAs("accessToken")))

  }

