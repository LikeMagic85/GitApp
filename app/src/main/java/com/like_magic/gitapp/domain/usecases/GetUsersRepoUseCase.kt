package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.domain.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class GetUsersRepoUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(url:String) =
        repository.getUsersRepo(url).flatMap {
            Single.fromCallable {
                it
            }
        }


}