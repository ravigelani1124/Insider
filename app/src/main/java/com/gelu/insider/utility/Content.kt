package com.gelu.insider.utility

import android.content.Context
import java.util.*


class Content(appContext: Context) {

    companion object {

        fun currentDate(): Date {
            val calendar = Calendar.getInstance()
            return calendar.time
        }

    }
}