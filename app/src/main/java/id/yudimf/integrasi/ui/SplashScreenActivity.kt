package id.yudimf.integrasi.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.yudimf.integrasi.HomeActivity
import id.yudimf.integrasi.R
import id.yudimf.integrasi.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        sharedPreferences = getSharedPreferences("UserPref", Context.MODE_PRIVATE)
//        sharedPreferences.edit().putString("username","testtest").apply()
//        sharedPreferences.edit().clear().apply()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)

    }
}