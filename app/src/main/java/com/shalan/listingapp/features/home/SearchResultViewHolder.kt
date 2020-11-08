package com.shalan.listingapp.features.home

import com.shalan.listingapp.base.network.response.Song
import com.shalan.listingapp.base.viewholder.BaseViewHolder
import com.shalan.listingapp.base.viewholder.ItemListener
import com.shalan.listingapp.databinding.SearchResultItemViewLayoutBinding

class SearchResultViewHolder(
    private val binding: SearchResultItemViewLayoutBinding,
    private val listener: ItemListener
) :
    BaseViewHolder<SearchResultItemViewLayoutBinding, Song>(binding, listener) {
    override fun bind(item: Song) {
        binding.ivSongCover.setImageBitmap(item.cover?.mediumBitmap)
        binding.song = item
        binding.executePendingBindings()

    }
}