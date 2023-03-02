package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.data.UserRepositoryImpl
import com.like_magic.gitapp.domain.entity.UserEntity

class LoadDataUseCase(private val repository: UserRepositoryImpl) {

    operator fun invoke(callback:(List<UserEntity>) -> Unit){
        repository.loadData {
            callback.invoke(it)
        }
    }

}