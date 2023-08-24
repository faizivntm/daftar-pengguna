package com.example.tugaseureka.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class UserModel(
    val login: String?,
    val followersUrl: String?,
    val followingUrl: String?,
    val id: Int?,
    @SerializedName("avatar_url")
    val avatarUrl: String?
)
