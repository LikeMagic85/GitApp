package com.like_magic.gitapp.data

import android.util.Log
import com.like_magic.gitapp.domain.UserRepository
import com.like_magic.gitapp.data.network.ApiFactory
import com.like_magic.gitapp.domain.entity.UserEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class UserRepositoryImpl : UserRepository {

    private val mapper = Mapper()
    private val compositeDisposable = CompositeDisposable()

    override fun loadData(callback: (List<UserEntity>) -> Unit) {
        val disposable = ApiFactory.apiService.getUserList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map{
                mapper.mapListDtoToListEntity(it)
            }
            .subscribe ({
                callback.invoke(
                    it
                )
            },{
                Log.d("TEST_OF_LOADING_DATA", "Failure: ${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    override fun getUser(login: String, callback: (UserEntity) -> Unit) {
        val disposable = ApiFactory.apiService.getUser(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                callback.invoke(
                    mapper.mapDtoToEntity(result)
                )
            }
        compositeDisposable.add(disposable)
    }
}