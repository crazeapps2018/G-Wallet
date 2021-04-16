package com.smartprotech.gwallet.ui.splash

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.smartprotech.gwallet.R
import com.smartprotech.gwallet.ui.auth.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_splash)

        val splashViewModel = ViewModelProviders.of(this)
            .get(SplashViewModel::class.java)
        splashViewModel.liveData.observe(this, Observer {
            when (it) {
                is SplashState.LoginActivity -> {
                    goToLoginActivity()
                }
            }
        })
    }

    private fun goToLoginActivity() {
        finish()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}