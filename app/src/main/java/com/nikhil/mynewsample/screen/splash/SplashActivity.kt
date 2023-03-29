package com.nikhil.mynewsample.screen.register.splash


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nikhil.mynewsample.R
import com.nikhil.mynewsample.screen.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splash = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        splash.start()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}