package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.domain.UserRepository
import com.like_magic.gitapp.domain.entity.UserRepoEntity

class GetUsersRepoUseCase(private val repository: UserRepository) {

    operator fun invoke(url:String, callback:(UserRepoEntity) -> Unit){
        repository.getUsersRepo(url){
            callback.invoke(it)
        }
    }

}