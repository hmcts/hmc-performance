package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Environment {

 val environment: String = System.getProperty("env")
 val idamURL = "https://idam-web-public.perftest.platform.hmcts.net"
// val baseURL = "http://hmc-cft-hearing-service-aat.service.core-compute-aat.internal"
 val baseURL = "http://hmc-cft-hearing-service-perftest.service.core-compute-perftest.internal"

 val IDAM_API_BASE_URI = "https://idam-api.perftest.platform.hmcts.net"

 val OAUTH_CLIENT = "xuiwebapp" //am_role_assignment // xuiwebapp / paybubble
// val S2S_BASE_URI = "http://rpe-service-auth-provider-aat.service.core-compute-aat.internal/testing-support"
 val S2S_BASE_URI = "http://rpe-service-auth-provider-perftest.service.core-compute-perftest.internal/testing-support"
 val S2S_SERVICE_NAME = "hmc_hmi_inbound_adapter"
 //val S2S_SERVICE_NAME = "am_role_assignment_service"
 //val S2S_SERVICE_NAME = "aac_manage_case_assignment"
  //val S2S_SERVICE_NAME = "aac_manage_case_assignment"
  val S2S_SERVICE_NAME2 = "api_gw"
 val IDAM_OAUTH_SECRET = "{123456}" //to be obtained from vault
 //val IDAM_OAUTH_SECRET = "JBS3NSGNKOQQ22G7"
 val FUNCTIONAL_TEST_CLIENT_S2S_TOKEN = ""

 val minThinkTime = 2
 val maxThinkTime = 5

 val commonHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive",
  "ServiceAuthorization" -> "${s2sToken}",
  //"Authorization" -> "${accessToken}")
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6IjRiYzlhMzkwLWU2Y2YtNGE0MS1iNTRmLWQwNjZmYzQ3NDg2Ny0yOTA2NDc3NjgiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IktrQlpCZzRIdlNiUUVBSE5fbk9JR0pGb1ZwWSIsIm5vbmNlIjoiRkt3dmZQLWx3OExLZlJQQi1SVDhvTFQxWHZndHM5WlpIR0k1M0wyN2V4SSIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcxMTAyMDUzNSwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MTEwMjA1MzQsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzExMDQ5MzM1LCJpYXQiOjE3MTEwMjA1MzUsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJkdGl6ZFg4UUhCTWw5VElpWkxBVFRudmExN00ifQ.DqEjFAoyCCbtdfTdEtkpnKZc9oH82VNaD2-iPCA2y7Wd69GydmCDoxdlsBM5963sXcHliKKuXkIGl-Zo75qg1HLfalzCrszPj9B1gmdsjBS4p6wXZSdPuSCBWvS3zIkF_A1X6jwjALc4h9ZO4X--UdSqxfRSdj_CfJPRpu1zWf9CODCW2W1xz6xA97JRKeZETVmjAPPEnOazMlHuq5GS9KCImzWZt3a-FmzxOWIsO-pkcdJ0dYSlbaaVvJbl9fGAHGNNSIo1ksgPX3yPmRB4WUNOZT1vy0wOKZDiWgY384JKBBX09AJ8SCCsx9gQg3uMim7hb1mc3QeZA8pbWNP6qg")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzEwOTQ0ODkxLCJuYmYiOjE3MTA5NDQ4OTEsImV4cCI6MTcxMDk0ODc5MSwiYWlvIjoiRTJOZ1lIaGkrSUJ6K1pubEpjb1hkSjJUT0d0MkFRQT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6InQzT2p5UTNYcDBxWXBDU0tLZVNCQUEiLCJ2ZXIiOiIxLjAifQ.b1J3RePMr8hpZO_3xD2UvkTwGZMGaXY3B7CNzt9rkCJRlbImjm48CUStXsF8LF5mZLgPMm7lS3yoWWFLqAL0cikVEWBl114Q22hBMIBHcMQnUyxiZaAIGzUUgM2HA4KGKTddUqwQUqTSvFvM1qLijhU3oSdx_YeDQIPNFNmX53-z5c0CZIhvQtA4vS1qmz6V6DSjwaKUaSniKYX0bKdrWpJTaKq4JDsxCvYTTOWCfun5p66JvNxvOd3Tr27fxy6IaVksJ0ckHhPX-_yq24xOqhafHBpchRgG7FSs_VMxluHgD0aTqMqtjqp1LufVdRph_ENTTwGJ1Y98TcQCFn-d8A")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


