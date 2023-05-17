package com.nikhil.mynewsample.api

import com.nikhil.mynewsample.screen.login.LoginAuthenticationRequestModel
import com.nikhil.mynewsample.screen.login.LoginAuthenticationResponseModel
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIInterface {

    @POST("api/authaccount/login")
    @Headers("Content-Type: application/json")
    suspend fun userLogin(@Body loginAuthenticationRequestModel: LoginAuthenticationRequestModel): LoginAuthenticationResponseModel

}