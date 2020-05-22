package com.gelu.insider.service

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("home")
    fun getEvent(
        @Query("norm") norm: Int,
        @Query("filterBy") filterBy: String,
        @Query("city") city: String
    ): Call<JsonObject>

}