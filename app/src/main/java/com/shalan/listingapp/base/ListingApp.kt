package com.shalan.listingapp.base

import android.app.Application
import com.shalan.listingapp.base.network.NetworkExecutor
import com.shalan.listingapp.base.services.SharedService
import com.shalan.listingapp.base.services.SharedServiceImp

class ListingApp : Application() {

    companion object {
        val executor = NetworkExecutor()
        var sharedService: SharedService? = null
    }

    override fun onCreate() {
        super.onCreate()
        sharedService = SharedServiceImp(this)
    }
}