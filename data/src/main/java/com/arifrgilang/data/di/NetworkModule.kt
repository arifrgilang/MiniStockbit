package com.arifrgilang.data.di

import com.arifrgilang.data.BuildConfig.*
import com.arifrgilang.data.WebSocketAPI
import com.tinder.scarlet.Scarlet
import org.koin.dsl.module

val networkModule = module {
    single { NetworkFactory.provideRetrofitBuilder(BASE_URL, API_KEY) }
    single { NetworkFactory.provideApiService(get()) }
    single { NetworkFactory.provideScarletService(BASE_URL_WEBSOCKET, API_KEY) }
}