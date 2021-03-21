package com.arifrgilang.data

import com.arifrgilang.domain.model.Subscribe
import com.arifrgilang.domain.model.WebSocketResponse
import com.tinder.scarlet.websocket.WebSocketEvent
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable

interface WebSocketAPI {
    @Send
    fun subscribe(request: Subscribe): Boolean

    @Receive
    fun observeResponse(): Flowable<WebSocketResponse>

    @Receive
    fun observeOnConnectionOpened(): Flowable<WebSocketEvent>
}