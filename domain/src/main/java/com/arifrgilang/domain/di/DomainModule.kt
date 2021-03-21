package com.arifrgilang.domain.di

import com.arifrgilang.domain.usecase.GetCryptoList
import org.koin.dsl.module

val domainModule= module {
    single {
        GetCryptoList(get())
    }
}