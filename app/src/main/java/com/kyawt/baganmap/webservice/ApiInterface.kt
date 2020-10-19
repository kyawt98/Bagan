package com.kyawt.baganmap.webservice

import com.kyawt.baganmap.Model.article
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    fun getItems(): Call<List<article?>?>?

}