package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Environment {

 val HttpProtocol = http

 val idamURL = "https://idam-api.#{env}.platform.hmcts.net"
 val baseURL = "http://hmc-cft-hearing-service-#{env}.service.core-compute-#{env}.internal"
 val ccdDataStoreUrl = "http://ccd-data-store-api-#{env}.service.core-compute-#{env}.internal"
 val IDAM_API_BASE_URI = "https://idam-api.#{env}.platform.hmcts.net"
 val OAUTH_CLIENT = "xuiwebapp" //am_role_assignment // xuiwebapp / paybubble
 val S2S_BASE_URI = "http://rpe-service-auth-provider-#{env}.service.core-compute-#{env}.internal/testing-support"
 val S2S_SERVICE_NAME = "hmc_hmi_inbound_adapter"
 val S2S_SERVICE_NAME2 = "api_gw"
 val IDAM_OAUTH_SECRET = "" //to be obtained from vault
 val FUNCTIONAL_TEST_CLIENT_S2S_TOKEN = ""

 val minThinkTime = 2
 val maxThinkTime = 5
 val constantthinkTime = 30 //7

  val commonHeader = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "Connection" -> "keep-alive",
    "ServiceAuthorization" -> "${ccd_dataBearerToken}",
    //"Authorization" -> "${accessToken}")
    // "Authorization" -> ""
    )

  val inboundcommonHeader = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "Connection" -> "keep-alive",
    "Source-System" -> "SNL",
    "Destination-System" -> "CFT",
    "Request-Type" -> "THEFT",
    "Request-Created-At" -> "2018-01-29T20:36:01Z",
    "Request-Processed-At" -> "2018-01-29 20:36:01Z",
    //"ServiceAuthorization" -> "${s2sToken}",
    "Authorization" -> ("Bearer ")
)

  val basicHeader = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "Connection" -> "keep-alive")

  val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
  val current_date = LocalDate.now().format(pattern)

}


