package utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Environment {

 val environment: String = System.getProperty("env")
 val idamURL = "https://idam-web-public.demo.platform.hmcts.net"
 val baseURL = "http://hmc-cft-hearing-service-demo.service.core-compute-demo.internal"

 val IDAM_API_BASE_URI = "https://idam-api.perftest.platform.hmcts.net"

 val OAUTH_CLIENT = "xuiwebapp" //am_role_assignment // xuiwebapp / paybubble
 val S2S_BASE_URI = "http://rpe-service-auth-provider-demo.service.core-compute-demo.internal/testing-support"
 val S2S_SERVICE_NAME = "hmc_hmi_inbound_adapter"
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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJaNEJjalZnZnZ1NVpleEt6QkVFbE1TbTQzTHM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzLnN1cGVydXNlckBtYWlsaW5hdG9yLmNvbSIsImN0cyI6Ik9BVVRIMl9TVEFURUxFU1NfR1JBTlQiLCJhdXRoX2xldmVsIjowLCJhdWRpdFRyYWNraW5nSWQiOiIzNDFlZWQ3MS1jNzM5LTQzMTMtOWYwNC1jNTdkNGM0ZDgyMzgtMjM2MzE4MjUiLCJpc3MiOiJodHRwczovL2Zvcmdlcm9jay1hbS5zZXJ2aWNlLmNvcmUtY29tcHV0ZS1pZGFtLWRlbW8uaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IkRIaFExdFhveTBZaDZ3Q1czZGpHa2ZoTHhmNCIsIm5vbmNlIjoiTmVZSzE4NTlfVHItaFBiVV94UFNrS0lDTHVhb21sdFBLNkxlRkJDaXpfUSIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTY1MzQwMjMxNSwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE2NTM0MDIzMTQsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNjUzNDMxMTE1LCJpYXQiOjE2NTM0MDIzMTUsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJXRFVNamFpRWt5Vm9VeGdXV3kzenlXMDJfMmsifQ.OkG6QSjZvCqXtMvKd8mp6PqD-h7ylmVHFOeWMYGjZ1v7lOD8sC9iCzdjNS1psZpRZhF_8byyIsiMRxRFZE835lwEAnvZopDmF527GocDEK-59s8Yc6NnNzx88U0IXbLsvXROWn0LgzgO_0bo0HhlyohE9DE7mV-TD6Kubc2PiYCIXL5LjZ2fr0266JuO7QRNcKy1Mxuh1h7FOQSj9BQzDxIkzOVtJ0QSdd7ID2VjxEAu-08YM_6MXTTIVMgJEngdrZ4FafWsPkoQfnq_TM38HcnmqbrEYx5eqpcON8rImqBUn-Hgaf_SwOu596g2qQ43oHISdyyhukGy7p_io_dPUw")

 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


