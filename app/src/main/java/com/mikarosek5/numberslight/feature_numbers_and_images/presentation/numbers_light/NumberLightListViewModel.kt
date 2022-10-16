package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mikarosek5.numberslight.feature_numbers_and_images.data.data_source.connectivity_observer.ConnectivityObserver
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLight
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.GetNumbersLightsListUseCase
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.wrappers.LightNumbersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NumberLightListViewModel @Inject constructor(
    private val useCases: LightNumbersUseCases
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _networkStatus = MutableLiveData<ConnectivityObserver.Status>()
    private val _list = MutableLiveData<List<NumberLight>>()
    val list: LiveData<List<NumberLight>>
        get() = _list

    val networkStatus: LiveData<ConnectivityObserver.Status>
        get() = _networkStatus

    fun getList(){
        disposable.add(
            useCases.getNumbersLightsListUseCase().subscribe(
                {onConsume-> _list.postValue(onConsume)},
                {onError-> Log.d("This is my error", onError.message?:"No message") }
            )
        )
    }

    fun getNetworkStatus(){
        disposable.add(
            useCases.getNetworkStatus().subscribe(
                {onConsume-> _networkStatus.postValue(onConsume)},
                {onError-> Log.d("This is my error", onError.message?:"No message")}
            )
        )
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}