package com.shalan.listingapp.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shalan.listingapp.base.states.IResult

abstract class BaseSingleListViewModel<T> : BaseViewModel() {

    protected val result: MutableLiveData<IResult<T>> by lazy {
        MutableLiveData()
    }

    val result_: LiveData<IResult<T>> = result

    abstract fun loadData()
}