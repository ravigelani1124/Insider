package com.gelu.insider.utility

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class TinyDb {

    companion object {

        val baseUrl: String = "https://api.insider.in/"
        val eventModel: String = "eventModel"
        val DEFULT_STRING = "-1"
    }

    private var sharedpreferences: SharedPreferences? = null
    private val MyPREFERENCES = "insider"

    constructor(appContext: Context) {
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(appContext)
        sharedpreferences = appContext.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
    }

    fun getString(key: String): String {
        return sharedpreferences!!.getString(key, DEFULT_STRING)!!
    }

    fun putString(key: String?, value: String?) {
        if (key == null) {
            throw NullPointerException()
        }
        if (value == null) {
            throw NullPointerException()
        }
        sharedpreferences!!.edit().putString(key, value).apply()
    }

    fun putInt(key: String?, value: Int?) {
        if (key == null) {
            throw NullPointerException()
        }
        if (value == null) {
            throw NullPointerException()
        }
        sharedpreferences!!.edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        return sharedpreferences!!.getInt(key, 0)
    }

    fun putBoolean(key: String?, value: Boolean) {
        if (key == null) {
            throw NullPointerException()
        }
        sharedpreferences!!.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        val DEFAULT_BOOLEAN = false
        return sharedpreferences!!.getBoolean(key, DEFAULT_BOOLEAN)
    }

    fun clear() {
        sharedpreferences!!.edit().clear().apply()

    }
}