package com.shalan.listingapp.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shalan.listingapp.base.network.response.Authorization
import com.shalan.listingapp.base.network.response.Song
import com.shalan.listingapp.base.states.IResult
import com.shalan.listingapp.base.viewmodel.BaseSingleListViewModel
import kotlinx.coroutines.launch


class HomeViewModel(private val repo: HomeRepo = HomeRepo()) :
    BaseSingleListViewModel<List<Song>>() {

    var searchQuery: String = ""

    private val authorizationResult: MutableLiveData<IResult<Authorization>> by lazy {
        MutableLiveData()
    }

    val authorizationResult_: LiveData<IResult<Authorization>> = authorizationResult

    override fun startLogic() {
        super.startLogic()
        if (repo.accessTokenAvailable() != true)
            processWithAuthorization()
    }

    fun processWithAuthorization() {
        authorizationResult.initialize()
        viewModelScope.launch {
            authorizationResult.value = repo.authorizeClient()
        }
    }

    override fun loadData() {
        result.initialize()
        viewModelScope.launch {
            result.value = repo.searchFor(searchQuery)
        }
    }
}