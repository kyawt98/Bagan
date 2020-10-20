package com.kyawt.baganmap.utils.network.interceptor

import com.kyawt.baganmap.utils.SharePreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor(
    private val prefHelper: SharePreferenceHelper
): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newRequest = request
            .newBuilder()
            .addHeader("Authorization",prefHelper.getToken())
            .build()

        return chain.proceed(newRequest)
    }

}

