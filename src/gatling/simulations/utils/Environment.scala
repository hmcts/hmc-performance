package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Environment {

 val environment: String = System.getProperty("env")
 val idamURL = "https://idam-web-public.perftest.platform.hmcts.net"
 //val baseURL = "http://hmc-cft-hearing-service-demo.service.core-compute-demo.internal"
 val baseURL = "http://hmc-cft-hearing-service-perftest.service.core-compute-perftest.internal"

 val IDAM_API_BASE_URI = "https://idam-api.perftest.platform.hmcts.net"

 val OAUTH_CLIENT = "xuiwebapp" //am_role_assignment // xuiwebapp / paybubble
 //val S2S_BASE_URI = "http://rpe-service-auth-provider-demo.service.core-compute-demo.internal/testing-support"
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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNDAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6IjlhNWRjODlhLTk2OTYtNDQyNC1iNGY5LWUxNjkxYzJhYWY3Ni04MjI4NDMwMyIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6Ijh6RkFzalphdTBuTUdWYUxiNDIzSThkUkpmayIsIm5vbmNlIjoiSzRCY0ZtMy0ybkYxaGQyUlBoR3lrUnVraW5YSWs4TElKbVlORTZ1XzRCYyIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTY1OTYyNDA5MywiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE2NTk2MjQwOTMsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNjU5NjUyODkzLCJpYXQiOjE2NTk2MjQwOTMsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJWb3hmanhSUWtQcUprdWsxdVNPMnVzbk96cEUifQ.cERMWI-FIyg1T2cgOlpxBzl04oPkQxna5kpsB5TgikSR0r0uZ-5OiC6hM9T0aA3EaFHuPOGe96ffrbOAEg2kYvpZSuEkbqtoaq2RKzMP3rqlhJL-1TjMrL3FXKaQgA6fkBLeNlhlGOBvzFRWYyzAMjDl3NwN5uMV7FI62xAphG5M7vHFm0tmwzBMv7fuOyiiJjvuh9j-HUe6gSdoMVK1xsHAIpb5td0rME7Nj5YpeWopxwWbPVs3g1f6KTPN2z3TOdWzSBlrEs0gTIzdotixeCcX6f-D6XzbVKsPhxClKcIzy4vNC6M_TLVw6AieBE0XVTjNabwGP-SEKD30fQ5zQg")



 val inboundcommonHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive",
  "ServiceAuthorization" -> "${s2sToken}",
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNEBqdXN0aWNlLmdvdi51ayIsImN0cyI6Ik9BVVRIMl9TVEFURUxFU1NfR1JBTlQiLCJhdXRoX2xldmVsIjowLCJhdWRpdFRyYWNraW5nSWQiOiJmMGVmN2E3NS1jNjRhLTRmN2UtOWY5Ny0yOGM1MTM5NjY4MWUtNjkyODg0NjkiLCJpc3MiOiJodHRwczovL2Zvcmdlcm9jay1hbS5zZXJ2aWNlLmNvcmUtY29tcHV0ZS1pZGFtLXBlcmZ0ZXN0LmludGVybmFsOjg0NDMvb3BlbmFtL29hdXRoMi9yZWFsbXMvcm9vdC9yZWFsbXMvaG1jdHMiLCJ0b2tlbk5hbWUiOiJhY2Nlc3NfdG9rZW4iLCJ0b2tlbl90eXBlIjoiQmVhcmVyIiwiYXV0aEdyYW50SWQiOiI0eC0wSnRibWdmXzdWWjRmRG52NHFtZnNPSXMiLCJub25jZSI6IkRNYWowMDM0M1hMMUk2c01UVk0zSl9qdldBVHhraGgwSGEtQk1mdVZHdkEiLCJhdWQiOiJ4dWl3ZWJhcHAiLCJuYmYiOjE2NTY0MzAyNzUsImdyYW50X3R5cGUiOiJhdXRob3JpemF0aW9uX2NvZGUiLCJzY29wZSI6WyJvcGVuaWQiLCJwcm9maWxlIiwicm9sZXMiLCJjcmVhdGUtdXNlciIsIm1hbmFnZS11c2VyIiwic2VhcmNoLXVzZXIiXSwiYXV0aF90aW1lIjoxNjU2NDMwMjc1LCJyZWFsbSI6Ii9obWN0cyIsImV4cCI6MTY1NjQ1OTA3NSwiaWF0IjoxNjU2NDMwMjc1LCJleHBpcmVzX2luIjoyODgwMCwianRpIjoiSVJ0YWN5QWMzNDVBOGhPYi1lQ2tUajlTZW9rIn0.bzWoWgoesFQUlkr5PJt5_usERG4FOAS9esaaHtxQAwdm7EpHLUnX8LJzi7fRAGzdwxLMUPIaXeQqXC1mshsb61IrAsF9q7VEkGQ09JjSQCsb-tS4FKRjnGTGTZNyKlxtRpIMiuaTm5-BtwfBtnvEQmC24lBJFbUVwi0PRPRqYXFWkE1Ky-lEIKgCJ6yVCDNr64O66K7oAivB6hZdTBG4TOoG_2I4TzSmmHvO4Gj1JRVQ3diRQvzGQvvUHzSCK_9_c8RbWkJvm5pSep3YaeyXJb0WFXFA8la_t54hSSQs4Qw6o_2m8i3vXf8C0IVricg2D4fI00-Ef9_HRx9Mh0cQKg")

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


