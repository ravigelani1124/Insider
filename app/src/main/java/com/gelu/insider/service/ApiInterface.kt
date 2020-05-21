package com.gelu.setup.service

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET
    fun getHomeDetails(
        @Query("norm") norm: Int,
        @Query("filterBy") filterBy: String,
        @Query("city") city: String
    ): Call<JSONObject?>?

}