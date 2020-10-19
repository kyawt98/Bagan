package com.kyawt.baganmap.webservice

import android.provider.Telephony.TextBasedSmsColumns.BODY
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private const val BASE_API_URL = "https://jsonplaceholder.typicode.com/"
    private var retrofit: Retrofit? = null
    private val gson = GsonBuilder().create()
    private val httpLoggingInterceptor:HttpLoggingInterceptor=HttpLoggingInterceptor()
    //private val httpLoggingInterceptor: HttpLoggingInterceptor =
    //    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClientBuilder = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
    private val okHttpClient = okHttpClientBuilder.build()
    fun createService(apiInterfaceClass: Class<ApiInterface?>?): ApiInterface {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit!!.create(ApiInterface::class.java)
    }
}

private fun OkHttpClient.Builder.addInterceptor(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
    TODO("Not yet implemented")
}

class HttpLoggingInterceptor {
    class Level {

    }

    fun setLevel(body: Any): HttpLoggingInterceptor {
        TODO("Not yet implemented")
    }

}
