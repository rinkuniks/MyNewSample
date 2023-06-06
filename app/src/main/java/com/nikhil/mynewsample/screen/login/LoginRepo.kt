package com.nikhil.mynewsample.screen.login

import android.util.Log
import androidx.lifecycle.LiveData
import com.nikhil.mynewsample.DataResource
import com.nikhil.mynewsample.NetworkResource
import javax.inject.Inject

class LoginRepo @Inject constructor(var loginService: LoginService) {
    private val TAG = "LoginActivity"

    fun authoriseLoginDetails(loginAuthenticationRequestModel: LoginAuthenticationRequestModel)
            : LiveData<DataResource<LoginAuthenticationResponseModel?>> {
        Log.d(TAG, "authoriseLoginDetails:3 ")

        val abc = object : NetworkResource<LoginAuthenticationResponseModel>() {

            override var isLoading: Boolean = true

            override fun processResponse(data: LoginAuthenticationResponseModel?)
                    : DataResource<LoginAuthenticationResponseModel?> {
                Log.d(TAG, "authoriseLoginDetails:9 ")
                return DataResource.success(data?.code, data)
            }

            override suspend fun createCall(): LoginAuthenticationResponseModel? {
                Log.d(TAG, "authoriseLoginDetails:10 ")
                return loginService.authoriseLoginDetails(loginAuthenticationRequestModel)
            }
        }

        return abc.toLiveData()
    }

}