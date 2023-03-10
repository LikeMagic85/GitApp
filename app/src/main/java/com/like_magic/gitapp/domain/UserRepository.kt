package com.like_magic.gitapp.domain

import com.like_magic.gitapp.domain.entity.UserEntity

interface UserRepository {

    fun loadData(callback: (List<UserEntity>) -> Unit)

    fun getUser(login:String, callback: (UserEntity) -> Unit)

}