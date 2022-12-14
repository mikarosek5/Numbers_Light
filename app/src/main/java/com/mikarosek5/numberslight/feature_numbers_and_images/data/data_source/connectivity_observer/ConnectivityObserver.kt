package com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.connectivity_observer

import io.reactivex.rxjava3.core.Observable


interface ConnectivityObserver {

    fun getStatus(): Observable<Status>

    enum class Status{
        Available,Unavailable
    }
}