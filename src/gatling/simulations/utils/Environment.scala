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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6IjRiYzlhMzkwLWU2Y2YtNGE0MS1iNTRmLWQwNjZmYzQ3NDg2Ny0yNzQ1MjUwMTEiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IkxqRHdYVExQUGp1SFNsc2E5aTFlel8xVWJZQSIsIm5vbmNlIjoicjFsRUU1M3RJc1F4SFoyaFJnTnRZa0dncnotVVVPVl95R0xEZmdhNHlKWSIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcxMDI2Mjg3NCwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MTAyNjI4NzMsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzEwMjkxNjc0LCJpYXQiOjE3MTAyNjI4NzQsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJLNjRvSklLN3hYZDlkMk0ydl9sMWNNeXB2VHMifQ.QQBGsCwQjPhAedN-mh5RFNb_jy1m9--N7QrX2C4QepE-TB5w7EiRlWDo2rJs4XZZzfWgIP1rjSoZq8u8_2-SmnHlIj_5EeqwWTLIF34CM4FUVx86zQ8esNKiHmtqlYOes2Gg6mBoD1Cynt8_Q3aXq8Fp3z4_A-KRuWewUgKoAoPIY5-i7sOXJcYpfKB2ABV9_B7v6AaFZkEv2AX9B8vgZFCom4_0qgej497Otpno6szbbB6etvXNC5I14-23lvP28h6kZ3sDuwvCyfngV11doUeY3OgYo-LZSj_lWMFqwqMv31Q5gLHQr3Sv0gCdaH4mSdiXA872XC5HnfO-uK84Wg")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzEwMjUxNTEwLCJuYmYiOjE3MTAyNTE1MTAsImV4cCI6MTcxMDI1NTQxMCwiYWlvIjoiRTJOZ1lMaTc2TEdXYS9rMWpvY1RvbXcyTFY3VUFRQT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6Ik85UUVESGpvNVVXMmdDd0hiUmdZQUEiLCJ2ZXIiOiIxLjAifQ.WzuWUMzhGFDk4k7kZXKUi3R8GHDu-ynTSWA5Uoumv-kyb9iD_-a5Op7arjanTT8e3MuE1Pses2KO8I_oCBB6tGYkY2pYjjMybVsY1ZW56roTSCxu1p8oA_fFLumdgHgpDZel2sTCuvjG85tfGy5PPRp_mELrdsUQr8gQYKD0UolydSjlNHnbXWWrJsMvAYRBNtkG5GeykrE8NFvIBc_upONkrCAoNakaGStesVgXvS2GB9q5pJyXUkTIrdrZLMZWWAHeoSq1ElkQpTew53wOs37DP9JkjyFmr_0VEAZoUVXgu7xR20VT2SqKgRmdAlYXXV9ovYVsyia2_nQdGX_iUw")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


