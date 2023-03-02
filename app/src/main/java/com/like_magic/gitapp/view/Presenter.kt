package com.like_magic.gitapp.view

import com.like_magic.gitapp.data.UserRepositoryImpl
import com.like_magic.gitapp.domain.usecases.LoadDataUseCase


class Presenter(private val activity: MainActivity) {

    private val repository = UserRepositoryImpl()
    private val loadDataUseCase = LoadDataUseCase(repository)


    fun setList() {
        loadDataUseCase{
            activity.userAdapter.submitList(it)
        }
    }

}