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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6Ijg0ZDg4NmE5LWEwODYtNGQ4MC1iNWJmLTQyMTBmM2ZmZmQ5Mi0xOTM3MTk5NzAiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6Ilc2dDI3MGdVek9Ra0lzeURMNkNGeUR4b1RtSSIsIm5vbmNlIjoiTWxGQm9uOGlTZ1lMQi0tdmRSR1hCLWdNTWF1SEZXem1KSUhvd0tFTE1DSSIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcxMTQ3MTU4OCwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MTE0NzE1ODcsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzExNTAwMzg4LCJpYXQiOjE3MTE0NzE1ODgsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiI4a0RpS0F0dEV3REF5YjVrWlZPbFRmaU9UTFUifQ.C_6FvZMG6Qd0Q2kW77S_eP8OtvlNAfiLvrBtBkJge0PziqIWFQd4dMrZVdge-KG4vhVHtXhq6eVmkeDjVzdMwBYkYQDa2HGZ0wcifKwkSQ8JYThKHIoqPVZ9d1erYlU9eqZTx8rHZDPEfydhHNYqVlzk9R1eNRJIOASWm2_-C2HOwvz8lGXtWo-_xiErFYBO02ApopJHr64IBOB4osshUjwnddfT1-lN8PqbquxXwRj61ubBGllluUKZu2-4O4xa6pa7857vBjRXH0EJv8dyCmXqsZTLXSTNUYK8KOta2SYfzsmNO2eA6nwHba5f5jbvUlANysYCacJwPJ7YWzZUUg")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzExMDQwMDk3LCJuYmYiOjE3MTEwNDAwOTcsImV4cCI6MTcxMTA0Mzk5NywiYWlvIjoiRTJOZ1lFaWFYSjkrc2xxL3ZPWHRqN2ozNjd6dUFRQT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6IjlvVlI4b3RwUVU2bUR0eVo3ZkVlQUEiLCJ2ZXIiOiIxLjAifQ.svaOluCslFSHFYPLGzvjIuSaoNoWouV-PjwdrAXpSfSoyYydpc9w-OeTcn4zWYEWlkdtlqchX_Uarhl9ubnLXlmbUDnEGZPfCHXYMsO43oEeEX3QbtHjfmcqYUbOXb5n9009pCD3uA6lL8L0JrK4oe2KMolQaxginT1TFCi9-GC-NAh_OgqUbxW1_nyi9UI56rKGoxVZyq7goafuQ3-n9DF3J0Aoh6JWc_lxnpvAkPXRw_nCAuKnaDaD9I2vfNiYg2qLgxsWF7m0X_bi6lvV5EkD2gATHE2YYi0QDiJz7z9m_xRrTFOtFp19v0y-jYuStOZXw1zuawJ3EvP4a9bK5w")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


