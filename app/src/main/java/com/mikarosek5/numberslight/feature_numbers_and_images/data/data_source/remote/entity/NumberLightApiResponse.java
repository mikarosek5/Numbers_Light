package com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity;

import com.google.gson.annotations.SerializedName;

public class NumberLightApiResponse {
    @SerializedName("name")
    public String id;
    @SerializedName("image")
    public String imageUrl;

    @Override
    public String toString() {
        return "NumbersLightsApiResponse{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
