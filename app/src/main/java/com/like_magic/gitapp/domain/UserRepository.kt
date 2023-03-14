package com.like_magic.gitapp.domain

import com.like_magic.gitapp.domain.entity.UserEntity
import com.like_magic.gitapp.domain.entity.UserRepoEntity

interface UserRepository {

    fun loadData(callback: (List<UserEntity>) -> Unit)

    fun getUser(login:String, callback: (UserEntity) -> Unit)

    fun getUsersRepoList(url:String, callback: (List<UserRepoEntity>) -> Unit)

    fun getUsersRepo(url:String, callback: (UserRepoEntity) -> Unit)

}