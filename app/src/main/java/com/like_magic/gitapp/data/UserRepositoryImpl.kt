package com.like_magic.gitapp.data

import android.app.Application
import com.like_magic.gitapp.data.database.AppDatabase
import com.like_magic.gitapp.domain.UserRepository
import com.like_magic.gitapp.data.network.ApiFactory
import com.like_magic.gitapp.domain.entity.UserRepoEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class UserRepositoryImpl(application: Application, private val networkStatus: INetworkStatus) : UserRepository {

    private val mapper = Mapper()
    private val database = AppDatabase.getInstance(application).usersDao()

    override fun loadData() =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                ApiFactory.apiService.getUserList()
                    .flatMap { users ->
                        Single.fromCallable {
                            val roomUsers = mapper.mapListEntityDtoToListDbModel(users)
                            database.insertListOfUsers(roomUsers)
                            mapper.mapListDtoToListEntity(users)
                        }
                    }
            } else {
                Single.fromCallable {
                   database.getAllUser().map {
                       mapper.mapDbModelToUserEntity(it)
                   }
                }
            }
        }.subscribeOn(Schedulers.io())


    override fun getUser(login: String)  =
        networkStatus.isOnlineSingle().flatMap {isOnline->
            if (isOnline){
                ApiFactory.apiService.getUser(login)
                    .flatMap { user->
                        Single.fromCallable {
                            mapper.mapDtoToEntity(user)
                        }
                    }
            }else{
                Single.fromCallable{
                    mapper.mapDbModelToUserEntity(database.getUser(login))
                }
            }
        }.subscribeOn(Schedulers.io())

    override fun getUsersRepoList(url: String) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                ApiFactory.apiService.getUsersReposList(url)
                    .flatMap {listRepos ->
                        Single.fromCallable {
                            listRepos.map{
                                mapper.mapRepoDtoToEntity(it)
                            }
                        }
                    }
            } else {
                Single.fromCallable{
                    listOf()
                }
            }
        }.subscribeOn(Schedulers.io())



    override fun getUsersRepo(url: String) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                ApiFactory.apiService.getUsersRepo(url)
                    .flatMap {repo ->
                        Single.fromCallable {
                            mapper.mapRepoDtoToEntity(repo)
                        }
                    }
            } else {
                Single.fromCallable{
                    UserRepoEntity(0, "", 0, "")
                }
            }
        }.subscribeOn(Schedulers.io())

}