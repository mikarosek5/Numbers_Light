package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLight
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.GetNumbersLightsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NumberLightListViewModel @Inject constructor(
    private val numberList: GetNumbersLightsListUseCase
) : ViewModel() {

    private val disposable = CompositeDisposable()
    private val _list = MutableLiveData<List<NumberLight>>()
    val list: LiveData<List<NumberLight>>
        get() = _list

    fun getList(){
        disposable.add(
            numberList().subscribe(
                {onConsume-> _list.postValue(onConsume)},
                {onError-> TODO("Not Implemented") }
            )
        )
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}