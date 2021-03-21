package com.arifrgilang.domain.usecase

import com.arifrgilang.domain.Repository
import com.arifrgilang.domain.SingleUseCase
import com.arifrgilang.domain.WebSocketUseCase
import com.arifrgilang.domain.model.Subscribe
import com.arifrgilang.domain.model.WebSocketResponse
import io.reactivex.Flowable
import io.reactivex.Single

class GetWebSocketList(
    private val repository: Repository
) : WebSocketUseCase<WebSocketResponse, Subscribe>() {
    override fun buildFlowableUseCase(params: Subscribe): Flowable<WebSocketResponse> =
        repository.doSubscribeSocket(params)
}