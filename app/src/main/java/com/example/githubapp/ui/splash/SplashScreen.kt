package com.example.githubapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView
import com.example.githubapp.R
import com.example.githubapp.databinding.ActivitySplashScreenBinding
import com.example.githubapp.ui.main.MainActivity

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val anim = findViewById<LottieAnimationView>(R.id.imageView)
        Handler(Looper.getMainLooper()).postDelayed({
            anim.playAnimation()
            binding.imageView1.playAnimation()
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}