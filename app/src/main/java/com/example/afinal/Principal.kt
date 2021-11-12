package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.afinal.databinding.PrincipalBinding

class Principal : AppCompatActivity() {
    private lateinit var binding: PrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PrincipalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.welcome.startAnimation(animation)
        binding.background.startAnimation(animation)

        binding.start.setTranslationX(-800F)
        binding.logo.setTranslationX(800F)

        binding.start.setAlpha(0F)
        binding.logo.setAlpha(0F)

        binding.start.animate().translationX(0F).alpha(1F).setDuration(1200).setStartDelay(600).start()
        binding.logo.animate().translationX(0F).alpha(1F).setDuration(1200).setStartDelay(600).start()

        binding.start.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.enter, R.anim.leave)
        }
    }
}