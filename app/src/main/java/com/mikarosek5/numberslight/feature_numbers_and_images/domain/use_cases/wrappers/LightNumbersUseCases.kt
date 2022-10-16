package com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.wrappers

import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.GetNetworkStatus
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.GetNumbersLightsListUseCase

data class LightNumbersUseCases(
    val getNetworkStatus: GetNetworkStatus,
    val getNumbersLightsListUseCase: GetNumbersLightsListUseCase
)
