package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.domain.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke(login: String) =
        repository.getUser(login).flatMap {
            Single.fromCallable {
                it
            }
        }
}