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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6ImIwYjg2ODMyLTk4YTItNDllMC1iYTZkLWZmYjUxYzY4ZjRmOS0yNjg4NzU1MzYiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6Im5kc2NCdUlYSldXNE8tVVZraHZOSTlIUmpYQSIsIm5vbmNlIjoiMFZWSVlKd1FWSmxIb1MyMzVYVGJRV21qM1E1ZFpIUkt0R085ZGkxX1hpUSIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcwOTYzMzQwMiwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MDk2MzM0MDIsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzA5NjYyMjAyLCJpYXQiOjE3MDk2MzM0MDIsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJUYzRQQlRxenY3SXFRSlN3bng4QjhoNzk1c28ifQ.CPNBel1AuD0g92PQ7iH-rPf6twPk1PBNeJDU_SgslKZIZpaByrm2MBMGyVwpS5-njAEJtjHjvZm3oWGFfIUk1Eeqb2v_zbD8BxXoXKuGHmEB5-4VMSgZl0GFCuYXRLulElSkVNJn9-Cv1KAT_YY8fuMH_nuI6-j8Z-UjSXBzF9vkFz0pgb7b6yX76_b4e7OQUFC5LbAXARXeKoPhZk3K6AhyMBC9j74-i6ZfkQNHfDco3D-HXIdu_BABdMvn5iLAGdW0OcIWZGiaerisk-4_nt8iyegTwMiI274weHTBI7hCEB4ho_sYgjS5IFmpe5LFjPiM2gkrKoSysTIb6OXHKw")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzA5OTA2NjcxLCJuYmYiOjE3MDk5MDY2NzEsImV4cCI6MTcwOTkxMDU3MSwiYWlvIjoiRTJOZ1lOQnF6cTl5NXI3aVArZk80azBmVnZhMUFRQT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6ImVyRjJPS3RCRDBDRUVocGVvWUxIQUEiLCJ2ZXIiOiIxLjAifQ.QZ9MEKueI3B8CNdS4ysmw0OAiCBtV3iDcUeA0L9fFr-SuYawE7W2Hfpwl6-Hg4eMCOIhIB7fcBoO91kuPgeSCdZIfbj8yHXwPip6AKYF0aX93iaxCAaVppUvidPvFqM4mfuh6YJpo-rbucfM9yvw8F50iL5iUAA90GuIziJ9qTlQizYNIUWz1-NBNIn-EQm_zAaP1N8xivcEdU_54xjypjGdj9pjgoNsJmts6ztLMuPkWa1sVu5eJ5ETEbsU3Fjbvj6z5fnkR4GjTrzIqNkRgd01gp6bwbzAMYVygObgMXPWq1DsFHfFSKApqXsb4AyENmgZYaLvY9eEAFGsEec1eQ")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


