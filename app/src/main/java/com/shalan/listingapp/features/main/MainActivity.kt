package com.shalan.listingapp.features.main

import android.os.Bundle
import androidx.activity.viewModels
import com.shalan.listingapp.R
import com.shalan.listingapp.base.activity.BaseActivity
import com.shalan.listingapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override val viewModel: MainViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreateInit(savedInstance: Bundle?) {

    }

}