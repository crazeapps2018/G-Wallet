package com.smartprotech.gwallet.data.repositories

import com.smartprotech.gwallet.data.firebase.FirebaseSource


class UserRepository (
    private val firebase: FirebaseSource
){
    fun login(email: String, password: String) = firebase.login(email, password)

    fun register(email: String, password: String) = firebase.register(email, password)

    fun currentUser() = firebase.currentUser()

    fun logout() = firebase.logout()

    fun sendPassword(email: String) = firebase.sendPassword(email)
}