package com.gelu.insider.service

import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import com.gelu.insider.R
import com.gelu.insider.utility.ConnectionDetector
import com.gelu.insider.utility.Loger
import com.gelu.insider.utility.TinyDb
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceGenerator {

    var obj: ServiceGeneratorInterfaceWithFailure? = null
    var context: Activity
    lateinit var contextLogOut: Context

    constructor(
        activity: Activity,
        obj1: ServiceGeneratorInterfaceWithFailure,
        call: Call<JsonObject>
    ) {
        obj = obj1
        this.context = activity

        if (!ConnectionDetector.isConnectedToInternet(context)) {
            Toast.makeText(
                context,
                context.resources.getString(R.string.str_no_internet),
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val dialog: Dialog = ProgressDialog(context)
        call.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call1: Call<JsonObject?>, response: Response<JsonObject?>) {

                dialog.dismiss()
                try {
                    Loger.LogError("onResponse", " -- " + response.body())
                    if (response.body() != null) {
                        obj!!.OnSuccess(response)
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call1: Call<JsonObject?>, t: Throwable) {
                dialog.dismiss()
                obj!!.OnFailure(t)
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }


    interface ServiceGeneratorInterfaceWithFailure {
        fun OnSuccess(response: Response<JsonObject?>)
        fun OnFailure(call1: Throwable)
    }


    companion object {

        fun createAPI(context: Context): ApiInterface {
            val okClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor { chain ->
                    val originalRequest = chain.request()
                    val requestBuilder = originalRequest.newBuilder()
                        .method(originalRequest.method(), originalRequest.body())
                    val request = requestBuilder.build()
                    chain.proceed(request)
                }
                .addNetworkInterceptor { chain ->
                    val original = chain.request()
                    val requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                    chain.proceed(requestBuilder.build())
                }
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(TinyDb.baseUrl)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}