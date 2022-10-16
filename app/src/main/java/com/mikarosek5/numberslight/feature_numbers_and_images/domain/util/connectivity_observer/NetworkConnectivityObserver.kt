package com.mikarosek5.numberslight.feature_numbers_and_images.domain.util.connectivity_observer

import io.reactivex.rxjava3.core.Observable
import java.net.InetAddress
import java.util.concurrent.TimeUnit

class NetworkConnectivityObserver : ConnectivityObserver {

    override fun getStatus(): Observable<ConnectivityObserver.Status> {
        return Observable.interval(1,TimeUnit.SECONDS).flatMap {
            return@flatMap Observable.create{
                it.onNext(isInternetAvailable())
            }
        }
    }

    private fun isInternetAvailable(): ConnectivityObserver.Status {
        return try {
            val ipAddress = InetAddress.getByName("google.com")
            if (!ipAddress.equals(""))
                ConnectivityObserver.Status.Available
            else
                ConnectivityObserver.Status.Unavailable
        } catch (exception: Exception) {
            ConnectivityObserver.Status.Unavailable
        }
    }

    //    private val connectivityManager = context
//        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    //    override fun getStatus(): Observable<ConnectivityObserver.Status> {
//        return Observable.create<ConnectivityObserver.Status>{
//            val callback = object : ConnectivityManager.NetworkCallback(){
//                override fun onAvailable(network: Network) {
//                    super.onAvailable(network)
//                    it.onNext(ConnectivityObserver.Status.Available)
//                }
//
//                override fun onLosing(network: Network, maxMsToLive: Int) {
//                    super.onLosing(network, maxMsToLive)
//                    it.onNext(ConnectivityObserver.Status.Unavailable)
//                }
//
//                override fun onLost(network: Network) {
//                    super.onLost(network)
//                    it.onNext(ConnectivityObserver.Status.Unavailable)
//                }
//
//                override fun onUnavailable() {
//                    super.onUnavailable()
//                    it.onNext(ConnectivityObserver.Status.Unavailable)
//                }
//            }
//            connectivityManager.registerDefaultNetworkCallback(callback)
//        }
//    } //require api 24
}