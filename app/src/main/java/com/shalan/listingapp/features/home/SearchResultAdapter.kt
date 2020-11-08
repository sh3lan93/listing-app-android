package com.shalan.listingapp.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.shalan.listingapp.R
import com.shalan.listingapp.base.adapter.BaseAdapter
import com.shalan.listingapp.base.adapter.ItemListener
import com.shalan.listingapp.base.network.response.Song
import com.shalan.listingapp.databinding.SearchResultItemViewLayoutBinding

class SearchResultAdapter(private val listener: ItemListener<Song>) :
    BaseAdapter<Song, SearchResultViewHolder>(diffUtil, listener) {

    companion object {
        val diffUtil: DiffUtil.ItemCallback<Song> = object : DiffUtil.ItemCallback<Song>() {
            override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean =
                oldItem == newItem
        }
    }

    override fun getViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder =
        DataBindingUtil.inflate<SearchResultItemViewLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.search_result_item_view_layout,
            parent,
            false
        )?.let {
            SearchResultViewHolder(it, this)
        }!!
}