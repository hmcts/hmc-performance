package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Environment {

 val environment: String = System.getProperty("env")
 val idamURL = "https://idam-web-public.demo.platform.hmcts.net"
 val baseURL = "http://hmc-cft-hearing-service-demo.service.core-compute-demo.internal"
 //val baseURL = "http://hmc-cft-hearing-service-perftest.service.core-compute-perftest.internal"

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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJaNEJjalZnZnZ1NVpleEt6QkVFbE1TbTQzTHM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzLnN1cGVydXNlckBtYWlsaW5hdG9yLmNvbSIsImN0cyI6Ik9BVVRIMl9TVEFURUxFU1NfR1JBTlQiLCJhdXRoX2xldmVsIjowLCJhdWRpdFRyYWNraW5nSWQiOiI2ODdiOTlmMS02OTE3LTRiNWYtYTMwZi1iNzA4ODEzNTgxMTUtMTMyODAwOTYiLCJpc3MiOiJodHRwczovL2Zvcmdlcm9jay1hbS5zZXJ2aWNlLmNvcmUtY29tcHV0ZS1pZGFtLWRlbW8uaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6Im5VQVE0cHY1REF0RXo5OEtHb0RHX21oUndwdyIsIm5vbmNlIjoiY0lycGlkcXZqZU9lbDJZZ1lkNmRUZG5VZWRDUDJFOFpkd0tyc3pxcHh5NCIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTY1NjM0MTk3MywiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE2NTYzNDE5NzMsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNjU2MzcwNzczLCJpYXQiOjE2NTYzNDE5NzMsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJIaVJJNjNael8yVUY3dWpZSHlYYUJueXZPWGMifQ.To7neP53zsfMP1DmqXE_1o3wGO8fWKWJVcQnizEKN9wScqafvl9LqX1xCWteHFVev4ufdGwbMbEBR6s4x80imgdm6xWP00-3pqfsUjbS2GjKwQQxM5XHyDgb8OcVuxBfSRxGpl2LFgjHMCC8CZ0yP4vB6wZ6Uf4_cuSK7rcP1xDvsomYOpCJgItwZUB6S_jCrvHHEteb7UloJ3C4oBahfUfeDyfqOmqOrw5oA1ROvTOUzkMmHprhyuuuJlQzibDX0wK9FBVhdPuke8W5nRu2QPirvwrJWNnfXx-8pOOXXOTf0PxejLL_Jhj47cinHNgUzuUSWE02KP2L6DdbmLf6mw")

 val inboundcommonHeader = Map(
  "accept" -> "*/*",
  "accept-encoding" -> "gzip, deflate, br",
  "Connection" -> "keep-alive",
  "ServiceAuthorization" -> "${s2sToken}",
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJaNEJjalZnZnZ1NVpleEt6QkVFbE1TbTQzTHM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzLnN1cGVydXNlckBtYWlsaW5hdG9yLmNvbSIsImN0cyI6Ik9BVVRIMl9TVEFURUxFU1NfR1JBTlQiLCJhdXRoX2xldmVsIjowLCJhdWRpdFRyYWNraW5nSWQiOiI2ODdiOTlmMS02OTE3LTRiNWYtYTMwZi1iNzA4ODEzNTgxMTUtMTMyODAwOTYiLCJpc3MiOiJodHRwczovL2Zvcmdlcm9jay1hbS5zZXJ2aWNlLmNvcmUtY29tcHV0ZS1pZGFtLWRlbW8uaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6Im5VQVE0cHY1REF0RXo5OEtHb0RHX21oUndwdyIsIm5vbmNlIjoiY0lycGlkcXZqZU9lbDJZZ1lkNmRUZG5VZWRDUDJFOFpkd0tyc3pxcHh5NCIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTY1NjM0MTk3MywiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE2NTYzNDE5NzMsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNjU2MzcwNzczLCJpYXQiOjE2NTYzNDE5NzMsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJIaVJJNjNael8yVUY3dWpZSHlYYUJueXZPWGMifQ.To7neP53zsfMP1DmqXE_1o3wGO8fWKWJVcQnizEKN9wScqafvl9LqX1xCWteHFVev4ufdGwbMbEBR6s4x80imgdm6xWP00-3pqfsUjbS2GjKwQQxM5XHyDgb8OcVuxBfSRxGpl2LFgjHMCC8CZ0yP4vB6wZ6Uf4_cuSK7rcP1xDvsomYOpCJgItwZUB6S_jCrvHHEteb7UloJ3C4oBahfUfeDyfqOmqOrw5oA1ROvTOUzkMmHprhyuuuJlQzibDX0wK9FBVhdPuke8W5nRu2QPirvwrJWNnfXx-8pOOXXOTf0PxejLL_Jhj47cinHNgUzuUSWE02KP2L6DdbmLf6mw")


 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


