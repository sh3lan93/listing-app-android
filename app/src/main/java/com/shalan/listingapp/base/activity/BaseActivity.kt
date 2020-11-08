package com.shalan.listingapp.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.shalan.listingapp.base.viewmodel.BaseViewModel

abstract class BaseActivity<ViewModel : BaseViewModel, Binding : ViewDataBinding> :
    AppCompatActivity(), IActivity {

    protected lateinit var binding: Binding
    abstract protected val viewModel: ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)
        viewModel.startLogic()
        onCreateInit(savedInstanceState)
    }


}