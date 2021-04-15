package com.smartprotech.gwallet.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.smartprotech.gwallet.data.repositories.UserRepository
import com.smartprotech.gwallet.utils.startLoginActivity

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }
    
    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }
}