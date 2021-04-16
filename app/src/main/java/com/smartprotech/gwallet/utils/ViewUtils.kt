package com.smartprotech.gwallet.utils

import android.content.Context
import android.content.Intent
import com.smartprotech.gwallet.ui.auth.LoginActivity
import com.smartprotech.gwallet.ui.home.HomeActivity
import com.smartprotech.gwallet.ui.payment.PaymentActivity

fun Context.startHomeActivity() =
    Intent(this, HomeActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }

fun Context.startLoginActivity() =
    Intent(this, LoginActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }

fun Context.startPaymentActivity()=
    Intent(this, PaymentActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }

