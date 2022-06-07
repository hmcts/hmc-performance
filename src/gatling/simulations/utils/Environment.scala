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
  "Authorization" -> "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJaNEJjalZnZnZ1NVpleEt6QkVFbE1TbTQzTHM9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJzc2NzLnN1cGVydXNlckBtYWlsaW5hdG9yLmNvbSIsImN0cyI6Ik9BVVRIMl9TVEFURUxFU1NfR1JBTlQiLCJhdXRoX2xldmVsIjowLCJhdWRpdFRyYWNraW5nSWQiOiIzNDFlZWQ3MS1jNzM5LTQzMTMtOWYwNC1jNTdkNGM0ZDgyMzgtMjcyOTM4NjUiLCJpc3MiOiJodHRwczovL2Zvcmdlcm9jay1hbS5zZXJ2aWNlLmNvcmUtY29tcHV0ZS1pZGFtLWRlbW8uaW50ZXJuYWw6ODQ0My9vcGVuYW0vb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9obWN0cyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IkVMSW5memdnZ3VqdGFROUk3SkVsb2dkazVlYyIsIm5vbmNlIjoiZzVnenFHRk9MRk5SeUdBREtIeVBwLUM0VkZhRUhRY2ZMTkJmeUg1UW8yMCIsImF1ZCI6Inh1aXdlYmFwcCIsIm5iZiI6MTY1NDA4OTUxOCwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiLCJyb2xlcyIsImNyZWF0ZS11c2VyIiwibWFuYWdlLXVzZXIiLCJzZWFyY2gtdXNlciJdLCJhdXRoX3RpbWUiOjE2NTQwODk1MTcsInJlYWxtIjoiL2htY3RzIiwiZXhwIjoxNjU0MTE4MzE4LCJpYXQiOjE2NTQwODk1MTgsImV4cGlyZXNfaW4iOjI4ODAwLCJqdGkiOiJiTVUyTW4yMGtITFhOUS1OazZMQmlPYnliQ00ifQ.AxhMKH8jGsfB_tDRY8kjJFXd6cyHULoB5pa-_t6iSxWxvd1JVTQiRDo74h3EIa-8DHo_L37zmjAM5aD444qqaT5MEUwtxmBeToU3Zs-nFPp24da-t5sldeZnKJ2qBrb5vI_O7LSTqhA-eVNwMLj6vTIH8cNHXIIFmWTotBVNY5Yn0FRpN2TEjKDB4cddIVg2-87T66S2iYZGetwun4Gytv_Egb2PI4ha2ChNVHZ6IlDJ0VSlFfPYsq8wpr4zKW0deXKTdCJVPJwoJ7O57tO-eH3sJm1VrTV1CK8qKD0GG2XZb-zvit2YfRKZjHxiy3PwLEKOaPJ5IpKVIX_mq6VIpg")

 val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 val current_date = LocalDate.now().format(pattern)

}


