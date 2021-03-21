package com.arifrgilang.ministockbit.ui.datafeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifrgilang.domain.base.state.Error
import com.arifrgilang.domain.base.state.Loading
import com.arifrgilang.domain.base.state.Success
import com.arifrgilang.domain.base.state.UiState
import com.arifrgilang.domain.model.Subscribe
import com.arifrgilang.domain.model.WebSocketResponse
import com.arifrgilang.domain.usecase.GetWebSocketList

class DatafeedViewModel(
    private val getWebSocketList: GetWebSocketList
) : ViewModel() {
    private val _response = MutableLiveData<WebSocketResponse>()
    private val _uiState = MutableLiveData<UiState>()

    val response: LiveData<WebSocketResponse> get() = _response
    val uiState: LiveData<UiState> get() = _uiState

    fun subscribeWebSocket() {
        _uiState.value = Loading
        val subscription = Subscribe("SubAdd", listOf("21~BTC", "21~DOGE"))
        getWebSocketList.execute(
            subscription,
            {
                _response.value = it
                _uiState.value = Success
            },{
                _uiState.value = Error(it)
            }
        )
    }
}