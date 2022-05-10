package utils

import com.warrenstrange.googleauth.GoogleAuthenticator
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment._

object  IDAMHelper {

    private val USERNAME = "hmcts.civil+organisation.2.solicitor.1@gmail.com"
    private val PASSWORD = "Password12!"


    val thinktime = Environment.thinkTime

    val getIdamToken =
      exec(http("010_GetAuthToken")
        .post(idamURL  + "/o/token?client_id=" + OAUTH_CLIENT + "&client_secret=" + IDAM_OAUTH_SECRET + "&grant_type=password&scope=openid profile roles search-user&username=${USERNAME}&password=${PASSWORD}")
        .header("Content-Type", "application/x-www-form-urlencoded")
        .header("Content-Length", "0")
        .check(status is 200)
        .check(jsonPath("$.access_token").saveAs("accessToken")))

  }

https://idam-web-public.demo.platform.hmcts.net/login?client_id=xuiwebapp&redirect_uri=https://manage-case.demo.platform.hmcts.net/oauth2/callback&state=SM1OLzGjUFZ3teAycw6WffeOGGbSNqsFwHmj2OiKHts&nonce=CplQCpxA7HkUP9OWu6mJoej1aoTAC7iOgmmjOMsSpbA&response_type=code&scope=profile%20openid%20roles%20manage-user%20create-user%20search-user&prompt=