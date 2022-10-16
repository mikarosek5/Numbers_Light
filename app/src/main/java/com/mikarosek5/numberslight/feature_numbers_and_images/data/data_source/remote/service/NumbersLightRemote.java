package com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.service;

import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity.NumberLightDetailApiResponse;
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.entity.NumberLightApiResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NumbersLightRemote {

    @GET(".")
    Observable<List<NumberLightApiResponse>> numbersAndLightsResponse();

    @GET(".")
    Observable<NumberLightDetailApiResponse> numberAndLightResponse(
            @Query("name") String id
    );
}
