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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6Ijg0ZDg4NmE5LWEwODYtNGQ4MC1iNWJmLTQyMTBmM2ZmZmQ5Mi0xNTA1MTQxOTkiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IlhXVURPV2M0UkJyQzAxTkl2azFmNEVVS0xZWSIsIm5vbmNlIjoia0t1UXRqbV9CRnJldGJBcVZZYzFvRlRPNWNuaFU5ZXdLcWNqSElJb1RzVSIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcwODk2OTg0NCwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MDg5Njk4NDQsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzA4OTk4NjQ0LCJpYXQiOjE3MDg5Njk4NDQsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiI4UFoxQjlGUExfTndKSEZCajVRY1owOWpZamsifQ.fKQLTzoTpqUCScW9mxGJbBVoPjbi8nu_jL10Uhnbj_su2XXWPIZUflyShbXWxDpAIWLsEQYklnj7YAK2LGYOdk1TdOjIOkn50aFMkB2SZ5wzvgVjLUadf3NZCvVWof4A9mHCmdrydcGxSpDb5hODSLLqXM3mM9aNXJQxl8IoI53T8cnQ9b9XbpCPv3jtMD8tnLk6ISLaZwbi3SbVHaEnxsv5BATTBidEIVQSePtKN8JMydSv-0Z7Dw25AeNKMVbwKyeGpnAzlJcy4FTdC3_JvJLApATy4WP2gIOiuZUFzjAN6_o-mEuHdztnbpDrNyQ35dRuFE-XGJj2YyCw4Cewsg")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzA4OTY5NDIzLCJuYmYiOjE3MDg5Njk0MjMsImV4cCI6MTcwODk3MzMyMywiYWlvIjoiRTJOZ1lEZ1hmRHZZcFNuSnRuZXg4QisxY3d4aUFBPT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6Il9Tc2tDTEVlMWtPbVNabHdud1U2QUEiLCJ2ZXIiOiIxLjAifQ.bbciA_r0b42pJwdrSFvxODbTZf0eKhtsnG4ynFHoR71Ypau3G2rzRWlCuZgRVJeLHvKkSIYdQYbC9OGeUTIsoJcy4ZMIAwQ3u-4awVQ-HeMuPb1LnwmOSj7UucIpVweSilCyR99xP7xkNdFxalr_xftfEVeYpBsQKyfZRCZY3obHsL9SlW_7r9OaG766UuDM6gm8zQVa-LxAwlZpVaF-skPlAJMg4myKvQ2D-PdLnL7XlE4hkC_3Ud-ma_I86iaurTyMMhxoBbhL-TB4PpK77AV6LVPCir7GWZFoUIi_I93E7t1mTYzX-oD2SXxm02cHxDzkzmmypKzhXWESBgAUkg")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


