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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6ImIwYjg2ODMyLTk4YTItNDllMC1iYTZkLWZmYjUxYzY4ZjRmOS0yNTM4NzE2MjciLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IlUzM3NkRWFnQzkyMXhUWVZBcHV4YXhPY1NPcyIsIm5vbmNlIjoieFkzaFIxVWI5MFFLQ255SGszeG0wa0Z3YWw0dlFzRFNKVkE3YWVaUlR4MCIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcwODQ0Mjg5MCwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MDg0NDI4ODksInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzA4NDcxNjkwLCJpYXQiOjE3MDg0NDI4OTAsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJuVnREYUNINVZ3cGJGNnluRVEwSVY3VUdQVjAifQ.CBDCNAmDZ5t9_85hID6TrQOgrc07RpdnMm0aY3t_jp3yCRWepo27nXZu52b0rOwguw1Z_Wp_60aQqbkudGukVJX0r_dWXcxvTKGreY5lA3d9ROOnOUVR74cDzHu6xNRU9pmaI6QAv1saEl7oUeweJRDb4jgUf3wyVl3lo3gff7-8BpgeZqAkSlZ3mWtrpWQlEFVlYG-YEjKjvlxzaMWU_OsaHNHezppg-lZGhW2fXsaPfU2slQbXgtoExg3IsD_76dQ8Z6JgWfp8utC2JmnfBhmXZtXUPRHcTXnld05k4GsH_qaJk3HbiYvJBAOCbA0Ky2jVFKcBS3ah00NYru7wKA")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6ImtXYmthYTZxczh3c1RuQndpaU5ZT2hIYm5BdyIsImtpZCI6ImtXYmthYTZxczh3c1RuQndpaU5ZT2hIYm5BdyJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzA4MzY4MTQzLCJuYmYiOjE3MDgzNjgxNDMsImV4cCI6MTcwODM3MjA0MywiYWlvIjoiRTJOZ1lQajNMbUYzYUhOUitoZUpINktXSGI5ekFRPT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6Iml3cDlONXFRWFUtaklUTnY2ZTBjQUEiLCJ2ZXIiOiIxLjAifQ.Vy4U-1Zjg_9j7PBZe7L3FswdtLfaNW-NEuNAu2tZpoFAY5TB3J0fxvBJdFxYmRo7AA_1-mGYcrvcNFIZm-v9mvNv1_W98lpZqqEEvSD5t0Xc9IIESxpl8GRJWzVAvF3lb0o-_TRLBhAs9fndDZvXvJNujcypI8aaXHTPdloeB9GrE7wl7Op9JWHWU5HWnRXlqiRim7VZj4v8btZVSzSvv7NHlt6Myimcd7wNirleBzsAeCJzbwrZGEKkQq5xIMvxWcz9a8nFoyy1iFS6hUbJVx4ZW7Nzk65tbKKkG9lC17nCKETPkhKHnJyBXGejUq065aHCZHhXL_LFf8koUEn14w")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


