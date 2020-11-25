package com.kyawt.baganmap.di.module
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BAGAN_MAP_BASE_URL = ""
private const val BAGAN_MAP_API_BASE_URL = ""

val networkModule = module {
    single(createdAtStart = true){ provideOkHttpClient()}

    factory { createConverterFactory() }
}

 fun provideOkHttpClient() : OkHttpClient{
    return OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()
}

private fun createConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create()
}

private inline fun <reified T> createService(
    okHttpClient: OkHttpClient,
    converterFactory: GsonConverterFactory,
    baseUrl: String = BAGAN_MAP_API_BASE_URL
): T {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()
        .create(T::class.java)
}