package com.arifrgilang.ministockbit.di

import com.arifrgilang.ministockbit.ui.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LoginViewModel()
    }
}