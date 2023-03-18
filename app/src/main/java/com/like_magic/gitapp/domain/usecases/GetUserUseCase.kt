package com.like_magic.gitapp.domain.usecases

import com.like_magic.gitapp.data.UserRepositoryImpl
import io.reactivex.Single

class GetUserUseCase(
    private val repository: UserRepositoryImpl
) {

    operator fun invoke(login: String) =
        repository.getUser(login).flatMap {
            Single.fromCallable {
                it
            }
        }
}