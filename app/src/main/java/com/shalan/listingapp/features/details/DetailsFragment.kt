package com.shalan.listingapp.features.details

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.shalan.listingapp.R
import com.shalan.listingapp.base.fragment.BaseFragment
import com.shalan.listingapp.databinding.FragmentDetailsBinding


class DetailsFragment :
    BaseFragment<DetailsViewModel, FragmentDetailsBinding>(R.layout.fragment_details) {
    override val viewmodel: DetailsViewModel by viewModels()

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateInit(savedInstanceState: Bundle?) {
        binding.song = args.song
    }

}