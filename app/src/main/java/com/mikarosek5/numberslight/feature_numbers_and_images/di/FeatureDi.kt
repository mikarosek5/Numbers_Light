package com.mikarosek5.numberslight.feature_numbers_and_images.di

import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.network_source.NumbersNetworkSource
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.network_source.NumbersNetworkSourceImpl
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.service.NumbersLightRemote
import com.mikarosek5.numberslight.feature_numbers_and_images.data.repository.NumbersRepositoryImpl
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.repository.NumbersRepository
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.GetNumberLightDetailsUseCase
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.GetNumbersLightsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeatureDi {

    @Singleton
    @Provides
    fun provideApi(): NumbersLightRemote = Retrofit.Builder()
        .baseUrl("http://dev.tapptic.com/test/json.php/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()
        .create(NumbersLightRemote::class.java)

    @Singleton
    @Provides
    fun provideNetworkSource(api: NumbersLightRemote): NumbersNetworkSource =
        NumbersNetworkSourceImpl(api)

    @Singleton
    @Provides
    fun provideRepository(networkSource: NumbersNetworkSource): NumbersRepository =
        NumbersRepositoryImpl(networkSource)

    @Singleton
    @Provides
    fun provideNumberDetailUseCase(repository: NumbersRepository): GetNumberLightDetailsUseCase =
        GetNumberLightDetailsUseCase(repository)

    @Singleton
    @Provides
    fun provideNumberListUseCase(repository: NumbersRepository): GetNumbersLightsListUseCase =
        GetNumbersLightsListUseCase(repository)
}