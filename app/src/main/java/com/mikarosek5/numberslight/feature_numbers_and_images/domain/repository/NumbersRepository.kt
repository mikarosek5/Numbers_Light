package com.mikarosek5.numberslight.feature_numbers_and_images.domain.repository


import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.connectivity_observer.ConnectivityObserver
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLight
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLightDetail
import io.reactivex.rxjava3.core.Observable

interface NumbersRepository {

    fun getNumbersLightsList() : Observable<List<NumberLight>>
    fun getNumberLightDetails(id:String) : Observable<NumberLightDetail>
    fun getNetworkStatus() : Observable<ConnectivityObserver.Status>
}