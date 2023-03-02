package com.like_magic.gitapp.data.network


import com.like_magic.gitapp.domain.dto.UserEntityDto
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("users")
    fun getUserList(): Call<List<UserEntityDto>>

}