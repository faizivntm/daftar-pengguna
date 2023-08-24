package com.example.tugaseureka.api

import com.example.tugaseureka.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
	@GET("/users") // Sesuaikan dengan endpoint yang sesuai
	fun getUsers(): Call<List<UserModel>>
}