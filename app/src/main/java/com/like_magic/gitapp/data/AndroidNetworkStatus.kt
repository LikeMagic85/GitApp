package com.like_magic.gitapp.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class AndroidNetworkStatus @Inject constructor(application: Application) : INetworkStatus {
    private val statusSubject: BehaviorSubject<Boolean> =
        BehaviorSubject.create()
    init {
        statusSubject.onNext(false)
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val request = NetworkRequest.Builder().build()
        connectivityManager.registerNetworkCallback(request, object :
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                statusSubject.onNext(true)
            }
            override fun onUnavailable() {
                statusSubject.onNext(false)
            }
            override fun onLost(network: Network) {
                statusSubject.onNext(false)
            }
        })
    }
    override fun isOnline() = statusSubject
    override fun isOnlineSingle() = statusSubject.first(false)
}



interface INetworkStatus{
    fun isOnline(): Observable<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}

