package com.shalan.listingapp.base.repo

import com.shalan.listingapp.base.ListingApp
import com.shalan.listingapp.base.network.NetworkExecutor
import com.shalan.listingapp.base.services.SharedService

interface IRepo {


    fun getExecutor(): NetworkExecutor = ListingApp.executor

    fun getSharedService(): SharedService? = ListingApp.sharedService
}