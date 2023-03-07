package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.data.UserRepositoryImpl
import com.like_magic.gitapp.domain.entity.UserEntity

class GetUserUseCase(private val repository: UserRepositoryImpl) {

    operator fun invoke(login:String, callback: (UserEntity) -> Unit) {
        repository.getUser(login) {
            callback.invoke(it)
        }
    }

}