package com.shalan.listingapp.base.fragment

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shalan.listingapp.base.states.CommonStatusImp
import com.shalan.listingapp.base.viewmodel.BaseSingleListViewModel

abstract class BaseSingleListFragment<T, ViewModel : BaseSingleListViewModel<T>, DataBinding : ViewDataBinding, Adapter : RecyclerView.Adapter<*>>(
    @LayoutRes layoutId: Int
) : BaseFragment<ViewModel, DataBinding>(layoutId), ISingleListFragment<T, Adapter> {

    override fun onCreateInit(savedInstanceState: Bundle?) {
        if (getRecyclerView().layoutManager == null)
            throw RuntimeException("you have to set the layout manager")

        getRecyclerView().adapter = getAdapter()
        observeDataChanges()
    }

    open fun observeDataChanges() {
        viewmodel.result_.observe(viewLifecycleOwner) { result ->
            when (result.whichStatus()) {
                CommonStatusImp.LOADING -> showLoading()
                CommonStatusImp.SUCCESS -> {
                    hideLoading()
                    result.fetchData()?.let { data ->
                        showData(data = data)
                    }
                }
                CommonStatusImp.ERROR -> {
                    hideLoading()
                    result.fetchError()?.second?.let { error ->
                        showError(error)
                    }
                }
            }
        }
    }
}