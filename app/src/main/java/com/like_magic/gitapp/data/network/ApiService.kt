package com.like_magic.gitapp.data.network


import com.like_magic.gitapp.domain.dto.UserEntityDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("users")
    fun getUserList(): Call<List<UserEntityDto>>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<UserEntityDto>

}