package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.afinal.databinding.LoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.tabs.TabLayout
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

enum class ProviderType{
    BASIC,
    GOOGLE,
    FACEBOOK
}

class Login : AppCompatActivity() {
    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Start animations
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.logo.startAnimation(animation)
        binding.money.startAnimation(animation)
        binding.text.startAnimation(animation)

        binding.google.setTranslationY(800F)
        binding.google.animate().translationY(0F).setStartDelay(600).setDuration(1200).start()
        binding.google.startAnimation(animation)

        binding.tw.setTranslationX(800F)
        binding.tw.animate().translationX(0F).setStartDelay(600).setDuration(1200).start()
        binding.tw.startAnimation(animation)

        binding.face.setTranslationX(-800F)
        binding.face.animate().translationX(0F).setStartDelay(600).setDuration(1200).start()
        binding.face.startAnimation(animation)


        binding.table.addTab(binding.table.newTab().setText("Ingresar"))
        binding.table.addTab(binding.table.newTab().setText("Registrar"))
        binding.table.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = Adapter(this, supportFragmentManager, binding.table.tabCount)
        binding.pager.adapter = adapter
        binding.pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.table))
        binding.table.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.pager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        //Firebase Implementation:

        //Custom Event Analitycs
        val analitycs: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analitycs.logEvent("InitScreen", bundle)

    }

    //Back animations
    override fun onBackPressed() {
        super.onBackPressed()
        val intent: Intent = Intent(this, Principal::class.java)
        startActivity(intent)
        this.overridePendingTransition(R.anim.leave_back, R.anim.enter_back)
    }

    //Show alert in auth user error
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}