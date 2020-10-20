package com.kyawt.baganmap.di.module

import com.kyawt.baganmap.utils.SharePreferenceHelper
import com.kyawt.baganmap.utils.network.interceptor.RequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideRequestInterceptor(pref: SharePreferenceHelper): RequestInterceptor {
        return RequestInterceptor(pref)
    }

    @Provides
    fun provideOkHttpClient(requestInterceptor: RequestInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addNetworkInterceptor(requestInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit.Builder {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)

    }

//    @Provides
//    fun provideMuseumAPI(retrofit: Retrofit.Builder): MuseumAPI {
//        return retrofit
//            .baseUrl(Network.BASE_URL)
//            .build()
//            .create(MuseumAPI::class.java)
//    }
}