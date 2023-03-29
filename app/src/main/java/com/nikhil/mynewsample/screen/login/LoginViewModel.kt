package com.nikhil.mynewsample.screen.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.nikhil.mynewsample.screen.login.LoginRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val loginRepo: LoginRepo
) : AndroidViewModel(application) {
    private val TAG = "LoginActivity"

    fun loginApi() {
        Log.d(TAG, "loginApi:2 ")
//        loginRepo.authoriseLoginDetails()
    }

}