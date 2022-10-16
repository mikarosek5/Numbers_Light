package com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases

import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLight
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.repository.NumbersRepository
import io.reactivex.rxjava3.core.Observable

class GetNumbersLightsListUseCase(private val repository: NumbersRepository) {
    operator fun invoke(): Observable<List<NumberLight>> = repository.getNumbersLightsList()
}