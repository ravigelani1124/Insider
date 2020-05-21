package com.gelu.insider.utility

import android.util.Log

/**
 * Created by webclues on 1/25/2017.
 */
object Loger {
    fun LogError(Tag: Any, Message: Any) {
        try {
            Log.e(Tag.toString(), "--$Message")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}