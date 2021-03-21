package com.arifrgilang.ministockbit.di

import com.arifrgilang.ministockbit.ui.login.LoginViewModel
import com.arifrgilang.ministockbit.ui.watchlist.WatchlistRecyclerAdapter
import com.arifrgilang.ministockbit.ui.watchlist.WatchlistViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LoginViewModel()
    }

    viewModel {
        WatchlistViewModel(get())
    }
}