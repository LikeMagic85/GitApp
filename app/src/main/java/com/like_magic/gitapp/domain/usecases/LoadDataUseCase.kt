package com.like_magic.gitapp.domain.usecases


import com.like_magic.gitapp.domain.UserRepository
import io.reactivex.Single
import javax.inject.Inject


class LoadDataUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke() =
        repository.loadData().flatMap {list ->
            Single.fromCallable {
                list
            }
        }
}