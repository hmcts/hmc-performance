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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiI4cDJpajg2S0pTeENKeGcveUovV2w3TjcxMXM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzSGVhcmluZ19tYW5hZ2VyNTAxQGp1c3RpY2UuZ292LnVrIiwiY3RzIjoiT0FVVEgyX1NUQVRFTEVTU19HUkFOVCIsImF1dGhfbGV2ZWwiOjAsImF1ZGl0VHJhY2tpbmdJZCI6IjRiYzlhMzkwLWU2Y2YtNGE0MS1iNTRmLWQwNjZmYzQ3NDg2Ny0yOTE3MjQwNDAiLCJzdWJuYW1lIjoic3Njc0hlYXJpbmdfbWFuYWdlcjUwMUBqdXN0aWNlLmdvdi51ayIsImlzcyI6Imh0dHBzOi8vZm9yZ2Vyb2NrLWFtLnNlcnZpY2UuY29yZS1jb21wdXRlLWlkYW0tcGVyZnRlc3QuaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6InB4WWhITS1UOFp3M2lpT29Bcjk1TUJBQzY4USIsIm5vbmNlIjoiSlVjOE1XWE93MWYyc1Y2bFE4b3V4Y09fSHRjZjV1SVdRbFdxZi13MnRHYyIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTcxMTAzOTAwMCwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE3MTEwMzkwMDAsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNzExMDY3ODAwLCJpYXQiOjE3MTEwMzkwMDAsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJ2OFNKMndDb3djX05lOUE4VUR1NFNtaF9icmMifQ.TtP6zRRBKvZzhnebMB1I81mEZSvdzNJEZmZPT6_xmCKUIOzGz9psxb3hNOJr_3Z6BuqPSl4GbAm3H-3FEq3YPq2gvzfbKkAKKZK4UpFQPE5BeU7J6Gz6wbClzbDECFaUe-pNZLraPmiqkqOOXdLFUzYx-cq0XOEt2MyBzQDmNpxchpQZRJaYvqG1pKmh1jflSrmDMbRA1Qyb86GAPRWKYT99o6Z9rfw6b4kMs_m0gPSSa71vstDhuo3qK3E_fYNVhXCZ10Yjl4a5H45IwCm7HGqvaY_-5bgJ4gr6Pn4HeYf5LzAQI2TuNTxRd-WvTETbSE0j4f8jagH1EzVpnozRvw")



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
  "Authorization" -> ("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJhcGk6Ly9kNDlkN2ZhMi02OTA0LTQyMjMtYTkwNy0zYjg5OTJhZjQxOTAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC81MzFmZjk2ZC0wYWU5LTQ2MmEtOGQyZC1iZWM3YzBiNDIwODIvIiwiaWF0IjoxNzExMDM1OTYxLCJuYmYiOjE3MTEwMzU5NjEsImV4cCI6MTcxMTAzOTg2MSwiYWlvIjoiRTJOZ1lIaGkrSUJ6K1pubEpjb1hkSjJUT0d0MkFRQT0iLCJhcHBpZCI6ImExMmU4MzU4LWZiZDgtNGE5OC04NGFhLWExMDYxNjFkZmJkNyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4Mi8iLCJvaWQiOiJlOGZiODQyMC1kYzVlLTRhNjItYTdlOS04NWQ4NGI0MzNkN2MiLCJyaCI6IjAuQVNBQWJma2ZVLWtLS2thTkxiN0h3TFFnZ25LaHozb21MXzVDbEd4Z0g4OHJwTklnQUFBLiIsInJvbGVzIjpbImhtaUdhdGV3YXlOb25Qcm9kIl0sInN1YiI6ImU4ZmI4NDIwLWRjNWUtNGE2Mi1hN2U5LTg1ZDg0YjQzM2Q3YyIsInRpZCI6IjUzMWZmOTZkLTBhZTktNDYyYS04ZDJkLWJlYzdjMGI0MjA4MiIsInV0aSI6IkRGR0VNa1RkQjB1bEJSTHdzbUlYQUEiLCJ2ZXIiOiIxLjAifQ.g37uFjX5Yaintear48ZOkQ4FDatNsfl9dKeYLF32HwYQeMgamJjv9x07jZ1pjftT_76VRsDA7_HQw5gkypdHSm20dPYhLe4T2gvQRdbQPQYnBqIW_GXWbY-Gne4E5WEqI4fic-vde0MeNcvyRYhyYF3NVeQYUPAeqAfj1u1JM6GqzTK4jj5c4JJOz4VRoAmjGh0Yf06j1Sgp8OUr9xADM_cKTkVZ_GIEw-7hjkro2E7QJoRA2WYxfLM3WJkR3JZS_797ftXRhfdGaaVzN7Q9kLCbvhX6XN4W4SPnifAizsVPwvFItKbGTlc4N_eDe_Ifm78DAA6j1VLKuOq8KXj7dA")
)

val basicHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive")



 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


