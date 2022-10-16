package com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.network_source

import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity.NumberLightDetailApiResponse
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity.NumberLightApiResponse
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.service.NumbersLightRemote
import io.reactivex.rxjava3.core.Observable

class NumbersNetworkSourceImpl(private val api: NumbersLightRemote) : NumbersNetworkSource {
    override fun getList(): Observable<List<NumberLightApiResponse>> {
        return api.numbersAndLightsResponse()
    }

    override fun getDetails(id:String): Observable<NumberLightDetailApiResponse> {
        return api.numberAndLightResponse(id)
    }
}