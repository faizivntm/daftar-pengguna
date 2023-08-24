package com.example.tugaseureka.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class UserModel(
//    @SerializedName("avatar_url") val avatarUrl: String,
    val id: Int,
    val email: String? = null,
    val first_name: String? = null,
    val last_name: String? = null,
    val avatar: String? = null
)
