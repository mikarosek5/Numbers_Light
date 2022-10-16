package com.mikarosek5.numberslight.feature_numbers_and_images.presentation.numbers_light_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.model.NumberLightDetail
import com.mikarosek5.numberslight.feature_numbers_and_images.domain.use_cases.GetNumberLightDetailsUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class NumberLightDetailsViewModel @Inject constructor(
    private val numberDetails: GetNumberLightDetailsUseCase
) : ViewModel() {

    private val disposable = CompositeDisposable()
    private val _detail = MutableLiveData<NumberLightDetail>()
    val detail: LiveData<NumberLightDetail>
        get() = _detail


    fun getDetail(id: String) {
        disposable.add(numberDetails(id).subscribe (
            {onConsume-> _detail.postValue(onConsume)},
            {onError->  }
        ))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}