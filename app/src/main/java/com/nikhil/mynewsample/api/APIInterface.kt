package com.nikhil.mynewsample.api

import android.database.Observable
import androidx.lifecycle.LiveData
import com.nikhil.mynewsample.login.LoginAuthenticationRequestModel
import com.nikhil.mynewsample.login.LoginAuthenticationResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIInterface {

    @POST("api/authaccount/login")
    @Headers("Content-Type: application/json")
    suspend fun userLogin(@Body loginAuthenticationRequestModel: LoginAuthenticationRequestModel): LoginAuthenticationResponseModel

}