package com.like_magic.gitapp.data.network


import com.like_magic.gitapp.domain.dto.UserEntityDto
import com.like_magic.gitapp.domain.dto.UserRepoEntityDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url


interface ApiService {

    @GET("users")
    fun getUserList(): Single<List<UserEntityDto>>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Single<UserEntityDto>

    @GET
    fun getUsersReposList(@Url url:String): Single<List<UserRepoEntityDto>>

    @GET
    fun getUsersRepo(@Url url:String): Single<UserRepoEntityDto>

}