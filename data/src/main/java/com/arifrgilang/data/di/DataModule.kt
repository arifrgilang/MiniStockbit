package com.arifrgilang.data.di

import com.arifrgilang.data.WebSocketAPI
import com.arifrgilang.data.repository.RepositoryImpl
import com.arifrgilang.domain.Repository
import com.tinder.scarlet.Scarlet
import org.koin.dsl.module

var dataModule = module {
    single<Repository> {
        RepositoryImpl(get(), get())
    }
}