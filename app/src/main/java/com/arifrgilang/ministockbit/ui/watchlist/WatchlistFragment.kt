package com.arifrgilang.ministockbit.ui.watchlist

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifrgilang.domain.base.state.UiState
import com.arifrgilang.domain.model.CryptoModel
import com.arifrgilang.ministockbit.R
import com.arifrgilang.ministockbit.base.BaseBindingFragment
import com.arifrgilang.ministockbit.databinding.FragmentWatchlistBinding
import com.arifrgilang.ministockbit.util.gone
import com.arifrgilang.ministockbit.util.loadHandler
import com.arifrgilang.ministockbit.util.observe
import com.arifrgilang.ministockbit.util.visible
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.viewModel

class WatchlistFragment : BaseBindingFragment<FragmentWatchlistBinding>() {
    lateinit var rvAdapter: WatchlistRecyclerAdapter
    override fun contentView(): Int = R.layout.fragment_watchlist
    private val viewModel by viewModel<WatchlistViewModel>()

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun setupView() {
        initRv()
        observeViewModel()
        viewModel.fetchData()
        binding.srWatchlist.onRefresh {
            viewModel.fetchData()
        }
    }

    private fun initRv() {
        rvAdapter = WatchlistRecyclerAdapter(activity)
        with(binding.rvWatchlist) {
            layoutManager = LinearLayoutManager(activity)
            adapter = rvAdapter
        }
    }

    private fun observeViewModel() {
        observe(viewModel.uiState, ::onLoading)
        observe(viewModel.response, ::onResponse)
    }

    private fun onLoading(state: UiState) {
        loadHandler(state,
                onLoading = { showLoadingState() },
                onSuccess = { hideLoadingState() },
                onError = {
                    hideLoadingState()
                    toast("$it.message")
                }
        )
    }

    private fun showLoadingState() {
        binding.srWatchlist.isRefreshing = true
        binding.rvWatchlist.gone()
    }

    private fun hideLoadingState() {
        binding.srWatchlist.isRefreshing = false
        binding.rvWatchlist.visible()
    }

    private fun onResponse(data: List<CryptoModel>) {
        rvAdapter.clearAndNotify()
        rvAdapter.insertAndNotify(data)
    }
}
