package com.like_magic.gitapp.view

import android.util.Log
import com.like_magic.gitapp.domain.usecases.GetUserUseCase
import com.like_magic.gitapp.domain.usecases.GetUsersRepoUseCase
import com.like_magic.gitapp.domain.usecases.GetUsersReposListUseCase
import com.like_magic.gitapp.domain.usecases.LoadDataUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class Presenter @Inject constructor(
    private val loadDataUseCase:LoadDataUseCase,
    private val getUserUseCase:GetUserUseCase,
    private val getUsersReposListUseCase:GetUsersReposListUseCase,
    private val getUsersRepoUseCase:GetUsersRepoUseCase,
    private val compositeDisposable:CompositeDisposable,
) : UsersContract.Presenter {

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
        userRepoFragmentView = null
    }


    override fun loadData() {
        val disposable = loadDataUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mainView?.showUsers(it)
            }, {
                mainView?.showError("${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    override fun getUser(login: String) {
        val disposable = getUserUseCase(login).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mainView?.navigateToUserPage(it)
            }, {
                mainView?.showError("${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    override fun getUsersRepoList(url: String) {
        val disposable = getUsersReposListUseCase(url).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                if(it.isNotEmpty()){
                    userFragmentView?.showUsersReposList(it)
                }else {
                    userFragmentView?.showSnackBar()
                }
            },{
                Log.d("@@@", "error")
        })
        compositeDisposable.add(disposable)
    }

    override fun getUsersRepo(url: String) {
        val disposable = getUsersRepoUseCase(url).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                userRepoFragmentView?.showRepo(it)
            }, {
                Log.d("@@@", "error")
            })
        compositeDisposable.add(disposable)
    }
}