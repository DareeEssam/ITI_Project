package com.example.iti_project

import MainActivity
import SecondActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.iti_project.databinding.ActivitySplashBinding

class SplashScreenActivity : AppCompatActivity(){

    lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)

        val sharedPref = applicationContext.getSharedPreferences("UserPref", MODE_PRIVATE)
        val isLogged = sharedPref.getBoolean("IS_LOGIN",false)
        Handler().postDelayed(Runnable {
            if(isLogged){
                startActivity(Intent(this,SecondActivity::class.java))

            }else {
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish()
        },3000)
    }
}