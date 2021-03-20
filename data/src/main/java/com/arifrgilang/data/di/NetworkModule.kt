package com.arifrgilang.data.di

import com.arifrgilang.data.BuildConfig
import org.koin.dsl.module

val networkModule = module {
    single { NetworkFactory.provideRetrofitBuilder(BuildConfig.BASE_URL, BuildConfig.API_KEY) }
    single { NetworkFactory.provideApiService(get()) }
}