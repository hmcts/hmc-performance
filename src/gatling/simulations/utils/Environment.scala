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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6Ijg0ZDg4NmE5LWEwODYtNGQ4MC1iNWJmLTQyMTBmM2ZmZmQ5Mi0xMzE2MjcwMjkiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IlhCT09vOExnLXFid0dhLTFQa3dTemZ4Um1kbyIsIm5vbmNlIjoiMU1sQnVjQnVnb25rXzJLMFJiMmFIbnE2WWRFSXVVNHc3UUJ4dXdSWmxLUSIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcwNzkzNTg0NywiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MDc5MzU4NDYsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzA3OTY0NjQ3LCJpYXQiOjE3MDc5MzU4NDcsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiIySzYwd1otb0s2c29Kbl83YWQ1b1VhaHFEUm8ifQ.Jj58Bk5GYbnxDyT_0c8x2ON1Fzmch_QB2y1cRGsmNoyXDKP0yxpUF0zC-mrpJNqiSWtpqxT5PetmpF6c2nc96w5pfetlJDgQ2rg9hMlIlP-p8eR-VlFUZdchLHKr6sWVC-9wcd1guaRi-QQZ84kaXlBPIFLTvM0hgazyzHDp611TTgu9ysOFbKLMs1M93cLuyP4-6oqgLYN55b7ZNdMUzbdyw8DeUHSOp8LAx9nBuIih1qRYafL-uMyaq_Zasmmmz2GWMLLGni2Yux7q8Uji3Cml_W2SqFZYJ8yeooNyzJPjcwze1ZA_XXgol-_4iMiMHzha_8lL_E9CKDROFub4gw")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6ImtXYmthYTZxczh3c1RuQndpaU5ZT2hIYm5BdyIsImtpZCI6ImtXYmthYTZxczh3c1RuQndpaU5ZT2hIYm5BdyJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzA3NzUyNjg2LCJuYmYiOjE3MDc3NTI2ODYsImV4cCI6MTcwNzc1NjU4NiwiYWlvIjoiRTJWZ1lKQStzUGpHUE9Pc0dMZXlMODNiM2lUOUFnQT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6ImtIYjQ2dm1iQ1VLTnZUZGhHN2FtQUEiLCJ2ZXIiOiIxLjAifQ.gSS-SAvuAeLSekPjMxuCjT_Tjzg-4YUiQdq5gjzxzZjKTJieK8gR2lQazIt57wORiLKSv_bSj3uVyZ23a6-R2tYlBMQd2_NSTviha_eswuQPt7u_tpIHnsE_K9ZFOupCrKze3_puMizZpkFnRTbsnuTezddwuqAEkoTsOcXCJREfNYOfCCvaut3MK5GeF6nelx7XFeJ31JQL_J8RVcxA73Dsr5C0taYoiMTnn-VBaExLsHOTs53PF8txpKFrmtjbalFLfpT057_3uEF_XEPaFkUJ5OozdnlAL51FAoBwNBrjGjh59Pv_VEGnum6ppQJXA-px8w8WuYvZ8Bb40LVAdg")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


