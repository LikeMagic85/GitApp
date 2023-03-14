package com.like_magic.gitapp.view

import com.like_magic.gitapp.data.UserRepositoryImpl
import com.like_magic.gitapp.domain.usecases.GetUserUseCase
import com.like_magic.gitapp.domain.usecases.GetUsersRepoUseCase
import com.like_magic.gitapp.domain.usecases.GetUsersReposListUseCase
import com.like_magic.gitapp.domain.usecases.LoadDataUseCase


class Presenter : UsersContract.Presenter {

    private val repository = UserRepositoryImpl()
    private val loadDataUseCase = LoadDataUseCase(repository)
    private val getUserUseCase = GetUserUseCase(repository)
    private val getUsersReposListUseCase = GetUsersReposListUseCase(repository)
    private val getUsersRepoUseCase = GetUsersRepoUseCase(repository)
    private var mainView: UsersContract.MainView? = null
    private var userFragmentView: UsersContract.UserFragmentView? = null
    private var userRepoFragmentView: UsersContract.UsersRepoFragmentView? = null
    override fun attach(mainView: UsersContract.MainView) {
        this.mainView = mainView
    }

    override fun attach(view: UsersContract.UserFragmentView) {
        this.userFragmentView = view
    }

    override fun attach(view: UsersContract.UsersRepoFragmentView) {
        this.userRepoFragmentView = view
    }

    override fun detach() {
        mainView = null
        userFragmentView = null
    }


    override fun loadData() {
        loadDataUseCase{
            mainView?.showUsers(it)
        }
    }

    override fun getUser(login: String) {
        getUserUseCase(login) {
            mainView?.navigateToUserPage(it)
        }
    }

    override fun getUsersRepoList(url: String) {
        getUsersReposListUseCase(url){
            userFragmentView?.showUsersReposList(it)
        }
    }

    override fun getUsersRepo(url: String) {
        getUsersRepoUseCase(url){
            userRepoFragmentView?.showRepo(it)
        }
    }
}