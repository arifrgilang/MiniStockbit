package com.arifrgilang.domain.di

import com.arifrgilang.domain.usecase.GetCryptoList
import com.arifrgilang.domain.usecase.GetWebSocketList
import org.koin.dsl.module

val domainModule= module {
    single {
        GetCryptoList(get())
    }

    single {
        GetWebSocketList(get())
    }
}