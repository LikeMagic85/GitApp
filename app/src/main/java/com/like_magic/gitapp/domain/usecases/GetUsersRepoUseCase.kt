package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.domain.UserRepository
import io.reactivex.Single

class GetUsersRepoUseCase(private val repository: UserRepository) {

    operator fun invoke(url:String) =
        repository.getUsersRepo(url).flatMap {
            Single.fromCallable {
                it
            }
        }


}