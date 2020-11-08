package com.shalan.listingapp.base.network.parser

import com.shalan.listingapp.base.network.JsonParser
import com.shalan.listingapp.base.network.response.Authorization
import org.json.JSONObject

class AuthorizationParser : JsonParser<Authorization> {

    override fun toJson(model: Authorization): String? = null

    override fun fromJson(json: String): Authorization? {
        val model: Authorization? = try {
            val jsonObject = JSONObject(json)
            Authorization(
                token = jsonObject.getString("accessToken"),
                type = jsonObject.getString("tokenType"),
                expiresIn = jsonObject.getString("expiresIn").toLong()
            )
        } catch (e: Exception) {
            null
        }
        model?.json = json
        return model
    }

}