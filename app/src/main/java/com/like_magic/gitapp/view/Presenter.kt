package com.like_magic.gitapp.view

import com.like_magic.gitapp.data.UserRepositoryImpl
import com.like_magic.gitapp.domain.usecases.GetUserUseCase
import com.like_magic.gitapp.domain.usecases.LoadDataUseCase


class Presenter : UsersContract.Presenter {

    private val repository = UserRepositoryImpl()
    private val loadDataUseCase = LoadDataUseCase(repository)
    private val getUserUseCase = GetUserUseCase(repository)
    private var view: UsersContract.View? = null
    override fun attach(view: UsersContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }


    override fun loadData() {
        loadDataUseCase{
            view?.showUsers(it)
        }
    }

    fun getUser(login: String) {
        getUserUseCase(login) {
            view?.navigateToUserPage(it)
        }
    }

}