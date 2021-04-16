package com.smartprotech.gwallet.ui.payment

import com.razorpay.Checkout
import org.json.JSONObject

interface PaymentListener {

    fun emptyAmount(msg:String)
    fun checkoutInstance(checkout: Checkout, jsonObject: JSONObject)
}