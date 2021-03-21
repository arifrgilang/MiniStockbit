package com.arifrgilang.ministockbit.ui.datafeed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arifrgilang.domain.base.state.UiState
import com.arifrgilang.domain.model.WebSocketResponse
import com.arifrgilang.ministockbit.R
import com.arifrgilang.ministockbit.base.BaseBindingFragment
import com.arifrgilang.ministockbit.databinding.FragmentDatafeedBinding
import com.arifrgilang.ministockbit.ui.watchlist.WatchlistViewModel
import com.arifrgilang.ministockbit.util.*
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.viewModel

class DatafeedFragment : BaseBindingFragment<FragmentDatafeedBinding>() {
    private val viewModel by viewModel<DatafeedViewModel>()

    override fun contentView(): Int = R.layout.fragment_datafeed

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun setupView() {
        observeViewModel()
        viewModel.subscribeWebSocket()
    }

    private fun observeViewModel() {
        observe(viewModel.uiState, ::onLoading)
        observe(viewModel.response, ::onResponse)
    }

    private fun onResponse(response: WebSocketResponse) {
        Log.d("WebSocket", response.toString())
        when(response.symbol) {
            "BTC" -> { binding.btcPrice = formatPrice(response.topTierFullVolume ?: 0.0) }
            "DOGE" -> { binding.dogePrice = formatPrice(response.topTierFullVolume ?: 0.0) }
        }
    }

    private fun onLoading(state: UiState) {
        loadHandler(
            state,
            onLoading = { showLoadingState() },
            onSuccess = { hideLoadingState() },
            onError = { toast("$it.message") }
        )
    }

    private fun showLoadingState() {
        binding.llDatafeed.gone()
        binding.pbDatafeed.visible()
    }


    private fun hideLoadingState() {
        binding.llDatafeed.visible()
        binding.pbDatafeed.gone()
    }
}