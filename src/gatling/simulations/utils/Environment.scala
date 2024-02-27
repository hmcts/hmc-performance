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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6ImIwYjg2ODMyLTk4YTItNDllMC1iYTZkLWZmYjUxYzY4ZjRmOS0yNjA1MDQwMjAiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IjZQZ216YVh2TWtqSnZodXVhQVZMSUFTSjFiRSIsIm5vbmNlIjoid1h0MUFLY0ZhVmVaRTF3cTNESmh4czJRdU9fdU9VM2lXaGVVbGE3bVNibyIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcwOTA1NTI5NiwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MDkwNTUyOTUsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzA5MDg0MDk2LCJpYXQiOjE3MDkwNTUyOTYsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJXTFNqQUJnUGFxWXpmdWxvXzg0cTZ5Zk1hOVEifQ.ANhKM8d4Rb6V5QbQyfZhBiFTzdmamAAaT29d3-NAhtsZKV-ktrYBTfaOq6LPUXtRLYf2UuYQqw5v6rrw6xIUq3oThXQCLkRJR8AvimGHgzLbEhqTWUhgJF-3YTulqsY39kIzb4If4LE9DTKFr3uh40XanYS4U0ECDLElpSLushmyIAkkmdQOZcZLlkUyrqQKwC4PgFPIdLuhj6HkWjwhddKQsPt_uybTWtawamnPtYtkcI6MPZtDu9zA5DegH0kEVkuaS1_SYTaedYSIybxOZdG7kFMTjnxW47KfsiSWSN2_wc0onUEGnnr0hKGtZjnKqquS030zgj3280VrusNQMw")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzA5MDUyMzQ0LCJuYmYiOjE3MDkwNTIzNDQsImV4cCI6MTcwOTA1NjI0NCwiYWlvIjoiRTJOZ1lGaW45K0VkMjlUK0F0dXJtVEdYNDJwMEFRPT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6IlZ3VDI2QmpGemt1S0M1elllenRtQUEiLCJ2ZXIiOiIxLjAifQ.akE4jb99qnQe24k8G-BWXqDziD8x_mNiIHHBLR0LYfXYemGHCRycwpB5SBUUvrXmwP-tDeRAYmkTtVl2NLncVoBBlxds1iVoP-URmO17Fws9v9S2kQRC3CzslBRvhzKbvFbx1Ml0Uk6i6uoJCa1PdBbiszVDPaTeCTaj6wxJdLroX-cfJwo7Nmry9PS8m2pm3vBhFe3hbu9Dc6VytElUfDKgZhYIHcKiwWkt6xLhZ_tuErM3bHI-VkCnA-qxT2XM8KsU22K8x2ltVD6QuZj4ZOfhqgXFCnkpr4k9wGUgV8BxKsg6gPY_BcN_g5lK74zQwafXmTgDXChn3fJg0aiXEg")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


