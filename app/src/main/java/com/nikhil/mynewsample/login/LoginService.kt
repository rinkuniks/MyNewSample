package com.nikhil.mynewsample.login

import android.util.Log
import androidx.lifecycle.LiveData
import com.nikhil.mynewsample.api.APIInterface
import javax.inject.Inject

class LoginService @Inject constructor(private val  apiInterface: APIInterface) {

    private val TAG = "LoginActivity"

   suspend fun authoriseLoginDetails(loginAuthenticationRequestModel: LoginAuthenticationRequestModel): LoginAuthenticationResponseModel? {
        Log.d(TAG, "authoriseLoginDetails: 4")
        return apiInterface.userLogin(loginAuthenticationRequestModel)
    }

}