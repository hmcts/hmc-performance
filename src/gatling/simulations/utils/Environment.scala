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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6IjRiYzlhMzkwLWU2Y2YtNGE0MS1iNTRmLWQwNjZmYzQ3NDg2Ny0yNTY0NDE1MTQiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6Im9ZSHlRLV9YX3hZVDh0Nk1aZGtjWk9KSVVEZyIsIm5vbmNlIjoiUHB1Um5URWhMdDZzaDR4X0pBbkp6eUJxVnRFSXBWLUk4bzdmbmduU21MUSIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcwODUzNzcwOSwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MDg1Mzc3MDksInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzA4NTY2NTA5LCJpYXQiOjE3MDg1Mzc3MDksImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJFSm1Mdnh2M1QwUWZIYnJXTnl6d3FkVWZZVWsifQ.fm-jLRYEn7hDVOt-ppzBuR_g175_SlnItc4_luU7_l5xRId_YejnCCdhWLDx-vB9gaDyzH6v0Kzy7SWiE_bzgMNjZRfTK-iIQIV0RkQo0J3TVqy8yS01DFQwjZcOhWfMMQzTHbsNYGmfLhL3zYZxEbvFU0oVrngeG8ONUcBnfxVBO73G592fmadLRhSGMe1rZjkuULYtgzJmM8ay-QZF6G5ILCTptqAodhUQsCQLw3Y78_hIWeiU29moOmZMqRAuc9PT4lnodhIaQi--Symq1ZyVoxIiG0pVKXZ8k-eq3xVhRb7G92vUvVMD1_3Nw_UxxNE6rFf8aLTUKpIGpkeQ9g")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6ImtXYmthYTZxczh3c1RuQndpaU5ZT2hIYm5BdyIsImtpZCI6ImtXYmthYTZxczh3c1RuQndpaU5ZT2hIYm5BdyJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzA4NTI5NDczLCJuYmYiOjE3MDg1Mjk0NzMsImV4cCI6MTcwODUzMzM3MywiYWlvIjoiRTJOZ1lCQlRzUDZ6Ky94V2Y5NVhYZE11djcvbUJBQT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6IktaclBWY2I1NEVTWmlUWE1pb0pMQUEiLCJ2ZXIiOiIxLjAifQ.k5b0Mw93K2aNT_uoCTbGMZDK8yDn6REitwIVHs0YV_qzkv4xpUYMXHWID6uKkif1AsnAMEoa_5bkBpuQgb0xiFGIy2d5tQjHbaZAQZiwvVI--nLOJ71XJIlDs7cowDf5Z46GIjy28XLSJPplPbUZXLjb6buf2DkvYrdU98j_OIoQo-I1qDX8UtyPrjv33YjN7TOq5VhGkoCFUtAo1eoSDGUqRaAf3PjBeN-ruKqdiCb1JwKmezQnvf-voOrZ7nOdUVK7Il_JYn-qJxL3ZXar-R5dJ1HivON4WVxIJvXoDH5WLwNpCLO0zpVcqTiY1K1vKxGpxd_FnCiazPgCXfX0xw")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


