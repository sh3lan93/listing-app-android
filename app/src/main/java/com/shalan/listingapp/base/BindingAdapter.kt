package com.shalan.listingapp.base

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.shalan.listingapp.base.network.response.CoverType
import com.shalan.listingapp.base.network.response.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL


@BindingAdapter("model", "type")
fun loadMediumCoverImage(view: ImageView, model: Song, type: CoverType) {
    when (type) {
        CoverType.TINY -> {
            if (model.cover?.tinyBitmap == null) {
                model.cover?.tiny?.let {
                    MainScope().launch {
                        Log.d("LOAD AN IMAGE", "loadAnImage: $it")
                        val bitmap = getBitmap(it)
                        model.cover.tinyBitmap = bitmap
                        view.setImageBitmap(bitmap)
                    }
                }
            }
        }
        CoverType.SMALL -> {
            if (model.cover != null && model.cover.smallBitmap == null) {
                model.cover.small?.let {
                    MainScope().launch {
                        Log.d("LOAD AN IMAGE", "loadAnImage: $it")
                        val bitmap = getBitmap(it)
                        model.cover.smallBitmap = bitmap
                        view.setImageBitmap(bitmap)
                    }
                }
            }
        }
        CoverType.MEDIUM -> {
            if (model.cover != null && model.cover.mediumBitmap == null) {
                model.cover.medium?.let {
                    MainScope().launch {
                        Log.d("LOAD AN IMAGE", "loadAnImage: $it")
                        val bitmap = getBitmap(it)
                        model.cover.mediumBitmap = bitmap
                        view.setImageBitmap(bitmap)
                    }
                }
            }
        }
        CoverType.LARGE -> {
            if (model.cover != null && model.cover.largeBitmap == null) {
                model.cover.large?.let {
                    MainScope().launch {
                        Log.d("LOAD AN IMAGE", "loadAnImage: $it")
                        val bitmap = getBitmap(it)
                        model.cover.largeBitmap = bitmap
                        view.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }
}

suspend fun getBitmap(url: String): Bitmap? {
    return withContext(Dispatchers.IO) {
        val url = URL(if (url.contains("http")) url else "http:$url")
        val bitmap = try {
            BitmapFactory.decodeStream(url.openConnection().getInputStream())
        } catch (e: Exception) {
            null
        }
        return@withContext bitmap
    }
}
