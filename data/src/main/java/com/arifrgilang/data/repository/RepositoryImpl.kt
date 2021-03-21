package com.arifrgilang.data.repository

import android.annotation.SuppressLint
import com.arifrgilang.data.CryptoCompareAPI
import com.arifrgilang.data.WebSocketAPI
import com.arifrgilang.domain.Repository
import com.arifrgilang.domain.base.response.ResponseArray
import com.arifrgilang.domain.model.CryptoModel
import com.arifrgilang.domain.model.CryptoRequestParam
import com.arifrgilang.domain.model.Subscribe
import com.arifrgilang.domain.model.WebSocketResponse
import io.reactivex.Flowable
import io.reactivex.Single

class RepositoryImpl(
    private val api: CryptoCompareAPI,
    private val webSocket: WebSocketAPI,
) : Repository {
    override fun getCryptoList(
        param: CryptoRequestParam
    ): Single<ResponseArray<CryptoModel>> =
        api.getCryptoList(param.limit, param.pageNum, param.tsym)

    @SuppressLint("CheckResult")
    override fun doSubscribeSocket(subscription: Subscribe) : Flowable<WebSocketResponse> {
        webSocket.subscribe(subscription)
        return webSocket.observeResponse()
    }
}