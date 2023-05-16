package com.nikhil.mynewsample.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginAuthenticationRequestModel(
    @Expose
    @SerializedName("email")
    var userName: String?="abc",
    @Expose
    @SerializedName("password")
    var pswd: String? ="check"
)
