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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJoZWFyaW5nc19hZG1pbl9yZWdpb24xX3VzZXJAanVzdGljZS5nb3YudWsiLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXV0aF9sZXZlbCI6MCwiYXVkaXRUcmFja2luZ0lkIjoiYjBiODY4MzItOThhMi00OWUwLWJhNmQtZmZiNTFjNjhmNGY5LTI2MDE3NzgzNyIsInN1Ym5hbWUiOiJoZWFyaW5nc19hZG1pbl9yZWdpb24xX3VzZXJAanVzdGljZS5nb3YudWsiLCJpc3MiOiJodHRwczovL2Zvcmdlcm9jay1hbS5zZXJ2aWNlLmNvcmUtY29tcHV0ZS1pZGFtLXBlcmZ0ZXN0LmludGVybmFsOjg0NDMvb3BlbmFtL29hdXRoMi9yZWFsbXMvcm9vdC9yZWFsbXMvaG1jdHMiLCJ0b2tlbk5hbWUiOiJhY2Nlc3NfdG9rZW4iLCJ0b2tlbl90eXBlIjoiQmVhcmVyIiwiYXV0aEdyYW50SWQiOiIxM1VKclJJaE5mTjF1bm9XQmZiRXF2dTdjU2MiLCJub25jZSI6ImVaNzVqX0gtTE1RWDVMX1dSc2JWY0ZGMnVHU3I0WXY5MGFzbFlvNnVkWGciLCJhdWQiOiJ4dWl3ZWJhcHAiLCJuYmYiOjE3MDg5Njg4MDEsImdyYW50X3R5cGUiOiJhdXRob3JpemF0aW9uX2NvZGUiLCJzY29wZSI6WyJvcGVuaWQiLCJwcm9maWxlIiwicm9sZXMiLCJjcmVhdGUtdXNlciIsIm1hbmFnZS11c2VyIiwic2VhcmNoLXVzZXIiXSwiYXV0aF90aW1lIjoxNzA4OTY4ODAwLCJyZWFsbSI6Ii9obWN0cyIsImV4cCI6MTcwODk5NzYwMSwiaWF0IjoxNzA4OTY4ODAxLCJleHBpcmVzX2luIjoyODgwMCwianRpIjoiZ2FIUXpCWG1yTGg4UVloQXVPUHJVY0VGN01jIn0.d_1rtvVXj7g8A_Jf3RR1iKrg7HkfL_GtWH7kcZ5gsr0h13AWUDgsQS34nqjT6e5cu--iMqBZRA30vGXL4drW8-SJ9x622RWu7WunVDq0ZYN-CsJ5SQ7nVFtmkvGUMRmKtBKeZmmf6KjXZQibYSErdlArIV3p2I7_LqwuZOHzX9sHcAHUQGZWP2VxZAOPrDoxiDvZz29wRzcndqhEvF0SRJQ_cwl9RbkpGG6HqKbDxqzi3qHyuTTRPN2ZJM2uNiR0ouEp4dMupfkLFMI92_2v-iJi609hIVmkbCELaxNd_izbwZFCADyMJtcw81hjemwQ54LBEZcUhCrheU8NJF7Z0Q")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzA4OTY4NjEwLCJuYmYiOjE3MDg5Njg2MTAsImV4cCI6MTcwODk3MjUxMCwiYWlvIjoiRTJOZ1lMZ1VXeHRsL3lqNjdlRWUzaDkvUHVYRkFRQT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6InQ3YWljWm96TWtDejNabWk5SVk5QUEiLCJ2ZXIiOiIxLjAifQ.kSXe2JETOZeE59_5H4bWkY1QErpJQtesLJCP48IGdtcl9-iwVOlIHGVmcbW_FRHFkuVCpa3ueErVcf4lXxQjltzUeK7o8s9JLYFCoWAgb0pM5kkq8RfeTsr_8rTv5rDODA1G643uzzfnKun98dT68bSlsSkvFur1qSy6bDnrmCkhdrF28DLIpppQEyCrCgDl4H8CT8Qshn02oF9DfUo08-Cr5WugBsmmMYi-wLEEFUD3PjcYe6RVhufYG1IDo1BHV69kff1hXWO_AqGy_fyy_YxcP3UUsLY-V7n_NSLvWOirDrPsPnSvY8_Ck2HZQpUfyug4xYixe1F_ZrvSalD-UA")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


