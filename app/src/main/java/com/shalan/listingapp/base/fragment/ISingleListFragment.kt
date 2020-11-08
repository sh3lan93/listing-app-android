package com.shalan.listingapp.base.fragment

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

interface ISingleListFragment<T, Adapter : RecyclerView.Adapter<*>> : IFragment {

    fun getRecyclerView(): RecyclerView

    fun showLoading()

    fun hideLoading()

    fun showError(error: String)

    fun showData(data: T)

    fun getAdapter(): Adapter

}