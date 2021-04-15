package com.smartprotech.gwallet.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.razorpay.Checkout
import org.json.JSONException

import org.json.JSONObject





class PaymentViewModel():ViewModel() {

    //email and password for the input
    var amount: String? = null

    //auth listener
    var paymentListener: PaymentListener? = null

    fun payment(view: View){

        if (amount.isNullOrEmpty()){
            paymentListener?.emptyAmount("Amount can't be empty")
        }
        // rounding off the amount.
        val amount = Math.round(amount!!.toFloat() * 100).toInt()

        // initialize Razorpay account.
        val checkout = Checkout()

        // set your id as below
        checkout.setKeyID("rzp_test_xcyzZkdFCDhWjC")

        // set image
       // checkout.setImage(R.drawable.payment)

        // initialize json object
        val jsonObject = JSONObject()
        try {
            // to put name
            jsonObject.put("name", "G Wallet")

            // put description
            jsonObject.put("description", "Test payment")

            // to set theme color
            jsonObject.put("theme.color", "")

            // put the currency
            jsonObject.put("currency", "INR")

            // put amount
            jsonObject.put("amount", amount)

            // put mobile number
            jsonObject.put("prefill.contact", "9779269052")

            // put email
            jsonObject.put("prefill.email", "mca2012veer@gmail.com")

            // open razorpay to checkout activity
            paymentListener?.checkoutInstance(checkout,jsonObject)


        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


}