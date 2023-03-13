package com.nikhil.mynewsample.login

import android.database.Observable
import android.util.Log
import androidx.lifecycle.LiveData
import com.nikhil.mynewsample.DataResource
import com.nikhil.mynewsample.NetworkResource
import com.nikhil.mynewsample.di.NetworkModule
import javax.inject.Inject

class LoginRepo @Inject constructor(var loginService: LoginService) {
    private val TAG = "LoginActivity"

    fun authoriseLoginDetails(loginAuthenticationRequestModel: LoginAuthenticationRequestModel)
            : NetworkResource<LoginAuthenticationResponseModel> {
        Log.d(TAG, "authoriseLoginDetails:3 ")
//        loginService.authoriseLoginDetails()

        return object : NetworkResource<LoginAuthenticationResponseModel>() {

            override fun processResponse(data: LoginAuthenticationResponseModel)
                    : DataResource<LoginAuthenticationResponseModel> {
                TODO("Not yet implemented")
            }

            override fun createCall(): LiveData<LoginAuthenticationResponseModel?> {
                return loginService.authoriseLoginDetails()
            }

        }

    }

}