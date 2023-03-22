package com.like_magic.gitapp.di

import android.app.Application
import com.like_magic.gitapp.data.AndroidNetworkStatus
import com.like_magic.gitapp.data.INetworkStatus
import com.like_magic.gitapp.data.UserRepositoryImpl
import com.like_magic.gitapp.data.database.AppDatabase
import com.like_magic.gitapp.data.database.UsersDao
import com.like_magic.gitapp.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: UserRepositoryImpl):UserRepository

    @Binds
    fun bindInetWorkStatus(impl: AndroidNetworkStatus):INetworkStatus

    companion object {

        @Provides
        fun provideCoinInfoDao(application: Application): UsersDao {
            return AppDatabase.getInstance(application).usersDao()
        }
    }

}