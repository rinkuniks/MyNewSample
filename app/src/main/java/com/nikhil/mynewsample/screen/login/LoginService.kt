package com.nikhil.mynewsample.screen.login

import android.util.Log
import androidx.lifecycle.LiveData
import com.nikhil.mynewsample.api.APIInterface
import com.nikhil.mynewsample.screen.login.LoginAuthenticationResponseModel
import javax.inject.Inject

class LoginService @Inject constructor(private val  apiInterface: APIInterface) {

    private val TAG = "LoginActivity"

   suspend fun authoriseLoginDetails(loginAuthenticationRequestModel: LoginAuthenticationRequestModel): LoginAuthenticationResponseModel? {
        Log.d(TAG, "authoriseLoginDetails: 4")
        return apiInterface.userLogin(loginAuthenticationRequestModel)
    }

}