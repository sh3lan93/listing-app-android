package com.shalan.listingapp.base.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<viewBinding : ViewDataBinding, T>(
    private val binding: viewBinding,
    private val listener: ItemListener? = null
) :
    RecyclerView.ViewHolder(binding.root) {


    fun baseBinding(item: T) {
        binding.root.setOnClickListener {
            listener?.onItemClicked(adapterPosition)
        }
        bind(item)
    }

    abstract fun bind(item: T)
}
