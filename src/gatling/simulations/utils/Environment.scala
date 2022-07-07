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
 //val S2S_SERVICE_NAME = "hmc_hmi_inbound_adapter"
 val S2S_SERVICE_NAME = "am_role_assignment_service"
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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNEBqdXN0aWNlLmdvdi51ayIsImN0cyI6Ik9BVVRIMl9TVEFURUxFU1NfR1JBTlQiLCJhdXRoX2xldmVsIjowLCJhdWRpdFRyYWNraW5nSWQiOiJmMGVmN2E3NS1jNjRhLTRmN2UtOWY5Ny0yOGM1MTM5NjY4MWUtNzA3OTU3MDMiLCJpc3MiOiJodHRwczovL2Zvcmdlcm9jay1hbS5zZXJ2aWNlLmNvcmUtY29tcHV0ZS1pZGFtLXBlcmZ0ZXN0LmludGVybmFsOjg0NDMvb3BlbmFtL29hdXRoMi9yZWFsbXMvcm9vdC9yZWFsbXMvaG1jdHMiLCJ0b2tlbk5hbWUiOiJhY2Nlc3NfdG9rZW4iLCJ0b2tlbl90eXBlIjoiQmVhcmVyIiwiYXV0aEdyYW50SWQiOiI0M244M2plUWk3TlNIeE9uLTQzbHpCdGJwMUkiLCJub25jZSI6IjF1Vmx6NUY5YUJ5eEhoMHRPWWEyT1AzWk5FR1RxN2pmakYyNE5Pb2Y3VUkiLCJhdWQiOiJ4dWl3ZWJhcHAiLCJuYmYiOjE2NTcwOTQ2NDIsImdyYW50X3R5cGUiOiJhdXRob3JpemF0aW9uX2NvZGUiLCJzY29wZSI6WyJvcGVuaWQiLCJwcm9maWxlIiwicm9sZXMiLCJjcmVhdGUtdXNlciIsIm1hbmFnZS11c2VyIiwic2VhcmNoLXVzZXIiXSwiYXV0aF90aW1lIjoxNjU3MDk0NjQxLCJyZWFsbSI6Ii9obWN0cyIsImV4cCI6MTY1NzEyMzQ0MiwiaWF0IjoxNjU3MDk0NjQyLCJleHBpcmVzX2luIjoyODgwMCwianRpIjoiY1FvQk9qM1ZWcm1UdTlBS0V4QU42Ymo4dWFrIn0.gxlLUEUDZehU01Hvr-erwmQx98YtvLYZ1ZDluCz_d3-1N-tQOz9JVwzctiOm41cvV4-WNI7gWFd1if4SWNxhwPk_relu6yUhT5j6w38lDp-YmdJ5pST42xftdr7a6_N7hHCAUbUSizkVilg8Wmhh5W84S1oq5z-iXvr449SjUrv7Kf4J7nfcUqYDO-hzBKw88INhDDBxRoyNrrOF68L4fi8M0Qec_CGPvF7kUPkuAqMFZ_LYFYJxU06EPf_ttut3fgRQHUVvMRrNQX-ozpazZHsQCTp41Msj9v_qDyJt5p9ea77HZ8vW9cRd4feIGr-c06BPJ6zZL8V-8RtaPViSpA")



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


