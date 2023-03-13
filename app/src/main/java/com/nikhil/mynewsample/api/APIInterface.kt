package com.nikhil.mynewsample.api

import android.database.Observable
import androidx.lifecycle.LiveData
import com.nikhil.mynewsample.login.LoginAuthenticationResponseModel
import retrofit2.http.GET

interface APIInterface {

    @GET("apicall/")
    fun userLogin(): LiveData<LoginAuthenticationResponseModel?>

}