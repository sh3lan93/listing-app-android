package com.shalan.listingapp.base.network

interface JsonParser<T> {


    fun toJson(model: T): String?

    fun fromJson(json: String): T?

}