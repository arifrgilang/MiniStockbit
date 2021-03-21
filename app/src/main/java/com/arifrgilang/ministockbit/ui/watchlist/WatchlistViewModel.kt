package com.arifrgilang.ministockbit.ui.watchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifrgilang.domain.SingleUseCase
import com.arifrgilang.domain.base.state.Error
import com.arifrgilang.domain.base.state.Loading
import com.arifrgilang.domain.base.state.Success
import com.arifrgilang.domain.base.state.UiState
import com.arifrgilang.domain.model.CryptoModel
import com.arifrgilang.domain.model.CryptoRequestParam
import com.arifrgilang.domain.usecase.GetCryptoList

class WatchlistViewModel(
    private val getCryptoList: GetCryptoList
) : ViewModel(){
    private val _response = MutableLiveData<List<CryptoModel>>()
    private val _uiState = MutableLiveData<UiState>()

    val response: LiveData<List<CryptoModel>> get() = _response
    val uiState: LiveData<UiState> get() = _uiState

    fun fetchData() {
        _uiState.value = Loading
        getCryptoList.execute(
                CryptoRequestParam(1,50,"USD"),
                {
                    _response.value = it.data
                    _uiState.value = Success
                },{
                    _uiState.value = Error(it)
                }
        )
    }
}