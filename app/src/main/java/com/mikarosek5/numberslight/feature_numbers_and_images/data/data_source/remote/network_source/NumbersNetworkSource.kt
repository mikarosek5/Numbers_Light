package com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.network_source

import io.reactivex.rxjava3.core.Observable
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity.NumberLightDetailApiResponse
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity.NumberLightApiResponse

interface NumbersNetworkSource {

    fun getList(): Observable<List<NumberLightApiResponse>>
    fun getDetails(id:String): Observable<NumberLightDetailApiResponse>
}