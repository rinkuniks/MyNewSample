package com.nikhil.mynewsample.screen.login

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Email")
    val email: String = "",
    @SerializedName("Token")
    val token: String = "",
    @SerializedName("Id")
    val id: Int = 0,
    @SerializedName("id")
    val Id: String = "",
    @SerializedName("Name")
    val name: String = ""
)