package com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity;

import com.google.gson.annotations.SerializedName;

public class NumberLightDetailApiResponse {
    @SerializedName("name")
    public String id;
    @SerializedName("text")
    public String word;
    @SerializedName("image")
    public String imageUrl;

    @Override
    public String toString() {
        return "NumberLightDetailApiResponse{" +
                "id='" + id + '\'' +
                ", word='" + word + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
