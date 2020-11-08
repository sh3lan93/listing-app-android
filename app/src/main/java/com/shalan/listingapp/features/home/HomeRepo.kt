package com.shalan.listingapp.features.home

import com.shalan.listingapp.BuildConfig
import com.shalan.listingapp.base.Constants
import com.shalan.listingapp.base.network.NetworkExecutor
import com.shalan.listingapp.base.network.NetworkExecutor.RequestMethod.Companion.GET
import com.shalan.listingapp.base.network.NetworkExecutor.RequestMethod.Companion.POST
import com.shalan.listingapp.base.network.parser.AuthorizationParser
import com.shalan.listingapp.base.network.parser.SearchParser
import com.shalan.listingapp.base.network.response.Authorization
import com.shalan.listingapp.base.network.response.Song
import com.shalan.listingapp.base.repo.BaseRepo
import com.shalan.listingapp.base.states.IResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepo : BaseRepo() {

    suspend fun authorizeClient(): IResult<Authorization> {
        return withContext(Dispatchers.IO) {
            getExecutor().invoke(
                requestMethod = POST,
                path = "v0/api/gateway/token/client",
                additionalHeaders = mapOf(
                    Pair(NetworkExecutor.GATEWAY_HEADER_KEY, BuildConfig.GATEWAYKEY),
                    Pair(
                        NetworkExecutor.CONTENT_TYPE_HEADER_KEY,
                        NetworkExecutor.FORM_URL_ENCODED_CONTENT_TYPE
                    )
                ),
                parser = AuthorizationParser()
            )!!.apply {
                fetchData()?.let {
                    getSharedService()?.save(Constants.PREF_TOKEN, "${it.type} ${it.token}")
                }
            }
        }
    }

    suspend fun searchFor(query: String, limit: Int = 20): IResult<List<Song>> {
        return withContext(Dispatchers.IO) {
            getExecutor().invoke(
                requestMethod = GET,
                path = "v2/api/sayt/flat?query=${query}&limit=${limit}",
                additionalHeaders = mapOf(
                    Pair(
                        NetworkExecutor.AUTHORIZATION_HEADER_KEY,
                        getSharedService()?.get(Constants.PREF_TOKEN, "") ?: ""
                    ),
                    Pair(NetworkExecutor.GATEWAY_HEADER_KEY, BuildConfig.GATEWAYKEY)
                ), parser = SearchParser()
            )!!
        }
    }

    fun accessTokenAvailable() = getSharedService()?.has(Constants.PREF_TOKEN)
}