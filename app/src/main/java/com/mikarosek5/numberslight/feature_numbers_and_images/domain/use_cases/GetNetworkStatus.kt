package com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases

import com.mikarosek5.numberslight.feature_numbers_and_images.domain.repository.NumbersRepository

class GetNetworkStatus(private val repository: NumbersRepository) {
    operator fun invoke() = repository.getNetworkStatus()
}