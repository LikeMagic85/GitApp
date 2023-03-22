package com.like_magic.gitapp.di

import android.app.Application
import com.like_magic.gitapp.view.MainActivity
import com.like_magic.gitapp.view.UserFragment
import com.like_magic.gitapp.view.UserReposListFragment
import dagger.BindsInstance
import dagger.Component
import io.reactivex.disposables.CompositeDisposable


@Component(modules = [DataModule::class])
interface AppComponent {

    fun inject(activity:MainActivity)

    fun inject(fragment:UserFragment)

    fun inject(fragment: UserReposListFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance compositeDisposable: CompositeDisposable
        ):AppComponent
    }

}