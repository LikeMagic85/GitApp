package com.like_magic.gitapp

import android.app.Application
import com.like_magic.gitapp.di.DaggerAppComponent
import io.reactivex.disposables.CompositeDisposable

class GitApp: Application() {

    private val compositeDisposable = CompositeDisposable()

    val component by lazy {
        DaggerAppComponent.factory()
            .create(this, compositeDisposable)
    }

}