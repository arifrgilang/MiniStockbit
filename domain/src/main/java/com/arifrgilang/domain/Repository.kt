package com.arifrgilang.domain

import com.arifrgilang.domain.base.response.ResponseArray
import com.arifrgilang.domain.model.CryptoModel
import com.arifrgilang.domain.model.CryptoRequestParam
import com.arifrgilang.domain.model.Subscribe
import com.arifrgilang.domain.model.WebSocketResponse
import io.reactivex.Flowable
import io.reactivex.Single

interface Repository {
    fun getCryptoList(
        param: CryptoRequestParam
    ): Single<ResponseArray<CryptoModel>>

    fun doSubscribeSocket(
        subscription: Subscribe
    ): Flowable<WebSocketResponse>
}