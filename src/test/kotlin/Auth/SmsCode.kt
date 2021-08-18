package Auth

import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

class SmsCode {


    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    fun get(phoneNumber: String): String? {  // Получение смс кода

        val request = Request.Builder()
            .url("https://rwminvest-dev.tecman.ru/client/v1/user/get-sms-code?phone=$phoneNumber")
            .build()
        client.newCall(request).execute().use { response ->
            return response.body()?.string()?.replace("\"","")
        }
    }
}