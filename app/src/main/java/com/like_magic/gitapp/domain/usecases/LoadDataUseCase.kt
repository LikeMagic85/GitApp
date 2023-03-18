package com.like_magic.gitapp.domain.usecases


import com.like_magic.gitapp.data.UserRepositoryImpl
import io.reactivex.Single


class LoadDataUseCase(private val repository: UserRepositoryImpl) {

    operator fun invoke() =
        repository.loadData().flatMap {list ->
            Single.fromCallable {
                list
            }
        }
}