package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.domain.UserRepository
import com.like_magic.gitapp.domain.entity.UserRepoEntity

class GetUsersReposListUseCase(private val repository: UserRepository) {

    operator fun invoke(url: String, callback: (List<UserRepoEntity>) -> Unit){

        repository.getUsersRepoList(url){
            callback.invoke(it)
        }

    }

}