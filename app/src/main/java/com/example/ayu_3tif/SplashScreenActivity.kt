package com.example.ayu_3tif

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        lifecycleScope.launch {
            delay(2000) //simulasi pengambilan data selama 2 detik

            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            var intent: Intent
            if (isLogin) {
                intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            } else {
                intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
            }

            startActivity(intent)
            finish()
        }
    }
}