package com.nikhil.mynewsample.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.nikhil.mynewsample.DataResource
import com.nikhil.mynewsample.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val loginRepo: LoginRepo
) : AndroidViewModel(application) {
    private val TAG = "LoginActivity"
    var loginResponseApi: MediatorLiveData<LoginAuthenticationResponseModel> = MediatorLiveData()
    var loginResponseApic: MutableLiveData<DataResource<LoginAuthenticationResponseModel>> = MutableLiveData()
    var loginRequest = LoginAuthenticationRequestModel()
    var isloading:MutableLiveData<Boolean> = MutableLiveData(false)

    fun loginApi() {
        loginRequest = LoginAuthenticationRequestModel().apply {
        userName = "Developer5@gmail.com"
            pswd = "123456"
        }
        loginResponseApi.addSource(loginRepo.authoriseLoginDetails(loginRequest), Observer {
            Log.d(TAG, "loginApi: ISDataReceived")
            when(it.status) {
                DataStatus.LOADING -> {
                    Log.d(TAG, "authoriseLoginDetails:: checkkk_1")
                    isloading.postValue(true)}
                DataStatus.SUCCESS -> {
                    Log.d(TAG, "authoriseLoginDetails:: checkkk${it.data?.data?.token}")
                    loginResponseApi.postValue(it.data!!)
                }
                    else -> {
                        Log.d(TAG, "loginApi: lets see")
                    }
            }

        })

//

    }

}