package com.like_magic.gitapp.data.network


import com.like_magic.gitapp.domain.dto.UserEntityDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("users")
    fun getUserList(): Single<List<UserEntityDto>>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Single<UserEntityDto>

}