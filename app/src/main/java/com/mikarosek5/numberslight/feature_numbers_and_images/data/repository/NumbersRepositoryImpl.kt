package com.mikarosek5.numberslight.feature_numbers_and_images.data.repository


import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.network_source.NumbersNetworkSource
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLight
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLightDetail
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.repository.NumbersRepository
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.util.toNumberDetail
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.util.toNumberLight
import io.reactivex.rxjava3.core.Observable

class NumbersRepositoryImpl(private val networkSource: NumbersNetworkSource) : NumbersRepository {
    override fun getNumbersLightsList(): Observable<List<NumberLight>> {
        return networkSource.getList().map { it.map { item -> item.toNumberLight() } }
    }

    override fun getNumberLightDetails(id: String): Observable<NumberLightDetail> {
        return networkSource.getDetails(id).map { it.toNumberDetail() }
    }
}