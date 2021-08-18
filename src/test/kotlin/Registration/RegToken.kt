package Registration

import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

class RegToken {
    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    fun get(userMail: String): String? {  // Получение токена регистрации 2го шага

        val request = Request.Builder()
            .url("https://rwminvest-dev.tecman.ru/client/v1/user/get-email-code?email=$userMail")
            .build()
        client.newCall(request).execute().use { response ->
            return response.body()?.string()?.replace("\"","")
        }
    }
}