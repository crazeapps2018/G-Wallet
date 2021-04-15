package com.smartprotech.gwallet.ui.home

import com.razorpay.Checkout
import org.json.JSONObject

interface PaymentListener {

    fun emptyAmount(msg:String)
    fun checkoutInstance(checkout: Checkout, jsonObject: JSONObject)
}