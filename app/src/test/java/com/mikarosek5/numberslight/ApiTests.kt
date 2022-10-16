package com.mikarosek5.numberslight

import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.remote.service.NumbersLightRemote
import org.junit.Test

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ApiTests {

    private fun provideApi() : NumbersLightRemote = Retrofit.Builder()
        .baseUrl("http://dev.tapptic.com/test/json.php/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()
        .create(NumbersLightRemote::class.java)

    @Test
    fun testRootCall() {
        val list = provideApi().numbersAndLightsResponse().blockingFirst()
        println(list)
        assert(list.size>0)
    }
    @Test
    fun testDetailsCall(){
        val details = provideApi().numberAndLightResponse("1").blockingFirst()
        println(details)
        assert(details.id=="1")
    }
}