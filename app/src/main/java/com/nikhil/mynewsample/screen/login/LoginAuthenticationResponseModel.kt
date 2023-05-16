package com.nikhil.mynewsample.screen.login

import com.google.gson.annotations.SerializedName
import com.nikhil.mynewsample.NikhilGenericApiResponse

data class LoginAuthenticationResponseModel(
    @SerializedName("data")
    val data: Data?,
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("id")
    val Id: String? = ""
) : NikhilGenericApiResponse()