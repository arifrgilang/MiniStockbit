package com.arifrgilang.data.di

import com.arifrgilang.data.BuildConfig.API_KEY
import com.arifrgilang.data.BuildConfig.BASE_URL
import org.koin.dsl.module

val networkModule = module {
    single { NetworkFactory.provideRetrofitBuilder(BASE_URL, API_KEY) }
    single { NetworkFactory.provideApiService(get()) }
}