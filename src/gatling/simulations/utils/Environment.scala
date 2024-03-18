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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6ImIwYjg2ODMyLTk4YTItNDllMC1iYTZkLWZmYjUxYzY4ZjRmOS0yODIyMjAxMjYiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6ImpZVUxtbjJJSzdEOEZ6NWduSHZ2dTV4RTBkOCIsIm5vbmNlIjoiQkJuT3hQLVFYZ3NQLW0xU3FvRW1mcnRJUHpSYVFzOFVKS3E1SDlUOXFuayIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcxMDc4MTUyNiwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MTA3ODE1MjMsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzEwODEwMzI2LCJpYXQiOjE3MTA3ODE1MjYsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJrcmdOYTcyNTlfeDB0QlNHX1hEaFNkSHVqNlUifQ.UX_QncL27zpjXRysZR8p-GFMI0rIzeXYBqqTJk651-YkCEPyEH7GptrIP4adV7Nvoq1ExeH40uzvM_ONDhIfNMYYwYfvjTc5AqF1eAtW0-5tVUsSuNag6MoERWlkTVfHrkWP64cDg_MHkt6Vl_4sFqMW8QJbYVIWx2xdVsxvEgyw0xnd9w1NJGaazbUMFkBe67BstaPr62auKInI6isQLR114GA0BvCjFOoDhWdVdyG_qKo00854Ik12_NkNB_qukPKjCuwRDeoWilE4-wKTY6dB32naU4SwsrBIDs9K91kNLAKEKZeFUkqgovkfpmPuKpvjslBPNQkl7Ftcll-tjA")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzEwNzc3MDI0LCJuYmYiOjE3MTA3NzcwMjQsImV4cCI6MTcxMDc4MDkyNCwiYWlvIjoiRTJOZ1lGalh2MEJyMXF1YUcwTHY1NnFMRnMzWkJ3QT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6IkhBLWVNWWRkS0VhblhfSTlTajRiQUEiLCJ2ZXIiOiIxLjAifQ.U2zFrWCoRVkqjQvResSVwTWrwe7ozX4VDdoBcNfmh45Q8X6YNRfQ_mG0QZX2CsVYk-ghoyfKV9IH1X0csyGPi6DQWtPrnhfR5M28rwRJVk9cdKc4lUrnTa8Je1mMuWm10QtOG0GV4K-ukeeL33vaFo-R_xnV74NwZe7p17yhnG6pC2-gahwVkM7hlaCzEOr4032F5duHhSyncpoQlBcMvPB-drEMoVarHyBPiu1HriU-I18XN9VktdkG6LUMlqrhkILcB2TTiMCf517tT5gLMhr7Sk4R3NkWrcdkSGjpQmHB75i0TAgicGe5GNoAwWhMs0Yhr58KxJIv9zs-mh7LxA")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


