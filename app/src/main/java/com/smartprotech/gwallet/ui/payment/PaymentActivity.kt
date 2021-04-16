package com.smartprotech.gwallet.ui.payment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.smartprotech.gwallet.R
import com.smartprotech.gwallet.databinding.ActivityPaymentBinding
import org.json.JSONObject
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class PaymentActivity: AppCompatActivity(),KodeinAware,PaymentResultListener,
    PaymentListener {


    override val kodein by kodein()
    private val factory : PaymentViewModelFactory by instance()

    private lateinit var viewModel: PaymentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityPaymentBinding = DataBindingUtil.setContentView(this, R.layout.activity_payment)
        viewModel = ViewModelProviders.of(this, factory).get(PaymentViewModel::class.java)
        binding.paymentviewmodel = viewModel

        viewModel.paymentListener = this
    }


    override fun emptyAmount(msg: String) {

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun checkoutInstance(checkout: Checkout, jsonObject: JSONObject) {

        checkout.open(this,jsonObject)
    }

    override fun onPaymentError(p0: Int, p1: String?) {

        Toast.makeText(this,p1,Toast.LENGTH_SHORT).show()

    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this,p0,Toast.LENGTH_SHORT).show()

    }


}