package utils

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Environment._
import com.typesafe.config.{Config, ConfigFactory}

object  IDAMHelper {

  val config: Config = ConfigFactory.load()
  private val USERNAME = "sscsHearing_manager501@justice.gov.uk"
  private val PASSWORD = "Password12"
  val ccdGatewayClientSecret = config.getString("auth.ccdGatewayCS")
  val ccdScope = "openid profile authorities acr roles openid profile roles"

  val getIdamToken =
  
    exec(http("010_GetAuthToken")
      .post(idamURL  + "/o/token?client_id=" + OAUTH_CLIENT + "&client_secret=" + ccdGatewayClientSecret + "&grant_type=password&scope=openid profile roles search-user&username=sscsHearing_manager501@justice.gov.uk&password=Password12")
      .header("Content-Type", "application/x-www-form-urlencoded")
      .header("Content-Length", "0")
      .check(status is 200)
      .check(jsonPath("$.access_token").saveAs("accessToken")))

  val GetIdamTokenSI =

    exec(http("GetIdamToken")
      .post(Environment.idamURL + "/o/token?client_id=ccd_gateway&client_secret=" + ccdGatewayClientSecret + "&grant_type=password&scope=" + ccdScope + "&username=SSCS-perftest-superuser@justice.gov.uk&password=Testing123")
      .header("Content-Type", "application/x-www-form-urlencoded")
      .header("Content-Length", "0")
      .check(status.is(200))
      .check(jsonPath("$.access_token").saveAs("accessToken")))

  }

