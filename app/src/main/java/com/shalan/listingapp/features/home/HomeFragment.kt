package com.shalan.listingapp.features.home

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.shalan.listingapp.R
import com.shalan.listingapp.base.adapter.ItemListener
import com.shalan.listingapp.base.fragment.BaseSingleListFragment
import com.shalan.listingapp.base.network.response.Song
import com.shalan.listingapp.base.states.CommonStatusImp
import com.shalan.listingapp.databinding.FragmentHomeBinding


class HomeFragment :
    BaseSingleListFragment<List<Song>, HomeViewModel, FragmentHomeBinding, SearchResultAdapter>(R.layout.fragment_home),
    ItemListener<Song> {

    companion object {
        val TAG = HomeFragment::class.java.simpleName
    }

    override val viewmodel: HomeViewModel by viewModels()

    private val searchResultAdapter: SearchResultAdapter by lazy {
        SearchResultAdapter(this)
    }

    override fun onCreateInit(savedInstanceState: Bundle?) {
        super.onCreateInit(savedInstanceState)
        binding.viewmodel = viewmodel
        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.etSearch.hideKeyboard()
                getAdapter().submitList(emptyList())
                viewmodel.searchQuery = binding.etSearch.text.toString()
                viewmodel.loadData()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        viewmodel.authorizationResult_.observe(viewLifecycleOwner, {
            when (it.whichStatus()) {
                CommonStatusImp.ERROR -> Log.i(TAG, "onCreateInit: ${it.fetchError()?.second}")
            }
        })
    }

    override fun getRecyclerView(): RecyclerView = binding.rvSearchResult

    override fun showLoading() {
        binding.loader.visibility = VISIBLE
    }

    override fun hideLoading() {
        binding.loader.visibility = GONE
    }

    override fun showError(error: String) {
        Snackbar.make(requireView(), error, Snackbar.LENGTH_LONG).show()
    }

    override fun showData(data: List<Song>) {
        getAdapter().submitList(data)
    }

    override fun getAdapter(): SearchResultAdapter = searchResultAdapter

    override fun onItemClicked(item: Song) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
    }
}