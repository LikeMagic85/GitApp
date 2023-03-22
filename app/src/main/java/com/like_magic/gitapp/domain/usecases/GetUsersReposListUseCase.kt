package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.domain.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class GetUsersReposListUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(url: String) =

        repository.getUsersRepoList(url).flatMap {
            Single.fromCallable {
                it
            }
        }



}