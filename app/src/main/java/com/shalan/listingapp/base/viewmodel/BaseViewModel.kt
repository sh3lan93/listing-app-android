package com.shalan.listingapp.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shalan.listingapp.base.states.IResult
import com.shalan.listingapp.base.states.Result

abstract class BaseViewModel : ViewModel(), IViewModel {


    fun <T> MutableLiveData<IResult<T>>.initialize() {
        this.value = Result.loading()
    }
}