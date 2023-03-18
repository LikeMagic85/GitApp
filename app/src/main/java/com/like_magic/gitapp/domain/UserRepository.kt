package com.like_magic.gitapp.domain

import com.like_magic.gitapp.domain.entity.UserEntity
import com.like_magic.gitapp.domain.entity.UserRepoEntity
import io.reactivex.Single

interface UserRepository {

    fun loadData(): Single<List<UserEntity>>

    fun getUser(login: String): Single<UserEntity>
    fun getUsersRepoList(url: String):Single<List<UserRepoEntity>>

    fun getUsersRepo(url: String):Single<UserRepoEntity>

}