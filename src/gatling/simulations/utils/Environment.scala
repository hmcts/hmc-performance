package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Environment {

 val environment: String = System.getProperty("env")
 val idamURL = "https://idam-web-public.demo.platform.hmcts.net"
 //val baseURL = "http://hmc-cft-hearing-service-demo.service.core-compute-demo.internal"
 val baseURL = "http://hmc-cft-hearing-service-perftest.service.core-compute-perftest.internal"

 val IDAM_API_BASE_URI = "https://idam-api.perftest.platform.hmcts.net"

 val OAUTH_CLIENT = "xuiwebapp" //am_role_assignment // xuiwebapp / paybubble
 val S2S_BASE_URI = "http://rpe-service-auth-provider-demo.service.core-compute-demo.internal/testing-support"
//val S2S_BASE_URI = "http://rpe-service-auth-provider-perftest.service.core-compute-perftest.internal/testing-support"
 val S2S_SERVICE_NAME = "hmc_hmi_inbound_adapter"
 //val S2S_SERVICE_NAME = "am_role_assignment_service"
 //val S2S_SERVICE_NAME = "aac_manage_case_assignment"
  //val S2S_SERVICE_NAME = "aac_manage_case_assignment"
  val S2S_SERVICE_NAME2 = "api_gw"
 //val IDAM_OAUTH_SECRET = "NVYEC2X7XFSRENTU" //to be obtained from vault
 val IDAM_OAUTH_SECRET = "JBS3NSGNKOQQ22G7"
 val FUNCTIONAL_TEST_CLIENT_S2S_TOKEN = ""

 val thinkTime = 15

 val minThinkTime = 5
 //10
 val maxThinkTime = 6
 //30

 val commonHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive",
  "ServiceAuthorization" -> "${s2sToken}",
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNEBqdXN0aWNlLmdvdi51ayIsImN0cyI6Ik9BVVRIMl9TVEFURUxFU1NfR1JBTlQiLCJhdXRoX2xldmVsIjowLCJhdWRpdFRyYWNraW5nSWQiOiJmMGVmN2E3NS1jNjRhLTRmN2UtOWY5Ny0yOGM1MTM5NjY4MWUtNjk2MTA3MjgiLCJpc3MiOiJodHRwczovL2Zvcmdlcm9jay1hbS5zZXJ2aWNlLmNvcmUtY29tcHV0ZS1pZGFtLXBlcmZ0ZXN0LmludGVybmFsOjg0NDMvb3BlbmFtL29hdXRoMi9yZWFsbXMvcm9vdC9yZWFsbXMvaG1jdHMiLCJ0b2tlbk5hbWUiOiJhY2Nlc3NfdG9rZW4iLCJ0b2tlbl90eXBlIjoiQmVhcmVyIiwiYXV0aEdyYW50SWQiOiJTU2h4c2F5bW5jM1BJYUZuQUh2dW8wWHJMQzQiLCJub25jZSI6IkhEY0YxSjVnSkVVc29mMkU3elVQT3hOX054OHNfekdCQ2RzQzdRVWh0R1kiLCJhdWQiOiJ4dWl3ZWJhcHAiLCJuYmYiOjE2NTY1NzQ0MTcsImdyYW50X3R5cGUiOiJhdXRob3JpemF0aW9uX2NvZGUiLCJzY29wZSI6WyJvcGVuaWQiLCJwcm9maWxlIiwicm9sZXMiLCJjcmVhdGUtdXNlciIsIm1hbmFnZS11c2VyIiwic2VhcmNoLXVzZXIiXSwiYXV0aF90aW1lIjoxNjU2NTc0NDE2LCJyZWFsbSI6Ii9obWN0cyIsImV4cCI6MTY1NjYwMzIxNywiaWF0IjoxNjU2NTc0NDE3LCJleHBpcmVzX2luIjoyODgwMCwianRpIjoiZ0RqbUl3dlE2d0hMYV90Y09PXzFQbnBET2hzIn0.bw7Jdq1upWlM1yKrf6g3Vx5kUWuaU3G-1FYc7mKRJ3s_sgvT3u9OAJ_1GLkaGv7rfrZdcuDdE6IeVjxWxD0KN4qtl61GhLKCJn9RGptMXiNhOeBbagoFSZSwLcIY0FZcDj_KTwPxnn9IXLc1Ei2k9QbhxDQeq1Uhk70YK4rWN1PQ0hfXBGk8DF4YAlEweEP4dqvPKUqna7135nOLC6m9ofHHv6D4kLm4tQ0f1XCLIJCeGuRIVf47Qf2gF0xt-y5aARND1hkK63lSOupxKSlfRHs4qGKkymc--vipNmZe7Wxd81yEKU5okUENliw-hKnNwiIVs2q22KgG72IpzqOLsg")

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


