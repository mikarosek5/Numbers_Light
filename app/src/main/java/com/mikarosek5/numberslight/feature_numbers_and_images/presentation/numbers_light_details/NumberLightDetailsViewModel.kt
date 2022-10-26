package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light_details

import androidx.lifecycle.ViewModel
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.GetNumberLightDetailsUseCase
import javax.inject.Inject

class NumberLightDetailsViewModel @Inject constructor(
    private val numberDetails: GetNumberLightDetailsUseCase
) : ViewModel() {
    fun getObservableDetail(id: String) = numberDetails(id)
}