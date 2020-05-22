package com.gelu.insider.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.gelu.insider.R

class SplashScreen : AppCompatActivity() {

    lateinit var mContext: SplashScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen)
        mContext = this

        Handler().postDelayed({ startApp() }, 2000)
    }


    private fun startApp() {
        startActivity(Intent(this, HomeScreen::class.java))
        finish()
    }
}
