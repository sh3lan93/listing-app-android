package com.shalan.listingapp.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.shalan.listingapp.base.viewmodel.BaseViewModel

abstract class BaseFragment<ViewModel : BaseViewModel, Binding : ViewDataBinding>(@LayoutRes layoutId: Int) :
    Fragment(layoutId), IFragment {

    protected lateinit var binding: Binding
    abstract protected val viewmodel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = viewLifecycleOwner
        viewLifecycleOwner.lifecycle.addObserver(viewmodel)
        viewmodel.startLogic()
        onCreateInit(savedInstanceState)
    }

    fun View.hideKeyboard() {
        (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
            hideSoftInputFromWindow(this@hideKeyboard.windowToken, 0)
        }
    }
}