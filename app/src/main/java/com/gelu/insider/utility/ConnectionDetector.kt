package com.gelu.insider.utility

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object ConnectionDetector {
    fun isConnectedToInternet(context: Activity): Boolean {
        val connectivity = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.allNetworkInfo
        for (i in info.indices) if (info[i].state == NetworkInfo.State.CONNECTED) {
            return true
        }
        return false
    }
}