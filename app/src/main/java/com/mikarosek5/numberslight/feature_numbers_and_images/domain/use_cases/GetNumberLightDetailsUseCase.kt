package com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases

import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLightDetail
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.repository.NumbersRepository
import io.reactivex.rxjava3.core.Observable

class GetNumberLightDetailsUseCase(private val repository: NumbersRepository) {

    operator fun invoke(id:String):Observable<NumberLightDetail>{
        return repository.getNumberLightDetails(id)
    }
}