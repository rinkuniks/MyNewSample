package com.nikhil.mynewsample.api

import androidx.lifecycle.LiveData
import com.nikhil.mynewsample.screen.login.LoginAuthenticationResponseModel
import retrofit2.http.GET

interface APIInterface {

    @GET("apicall/")
    fun userLogin(): LiveData<LoginAuthenticationResponseModel?>

}