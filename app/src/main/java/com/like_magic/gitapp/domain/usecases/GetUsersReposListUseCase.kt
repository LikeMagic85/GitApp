package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.domain.UserRepository
import io.reactivex.Single

class GetUsersReposListUseCase(private val repository: UserRepository) {

    operator fun invoke(url: String) =

        repository.getUsersRepoList(url).flatMap {
            Single.fromCallable {
                it
            }
        }



}