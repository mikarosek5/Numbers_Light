package com.mikarosek5.numberslight.feature_numbers_and_images.domain.util

import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity.NumberLightApiResponse
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity.NumberLightDetailApiResponse
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLight
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLightDetail

fun NumberLightDetailApiResponse.toNumberDetail() = NumberLightDetail(
    this.id,
    this.word,
    this.imageUrl
)

fun NumberLightApiResponse.toNumberLight() = NumberLight(
    this.id,
    this.imageUrl
)