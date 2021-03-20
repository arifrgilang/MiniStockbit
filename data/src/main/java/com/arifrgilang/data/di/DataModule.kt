package com.arifrgilang.data.di

import com.arifrgilang.data.repository.RepositoryImpl
import com.arifrgilang.domain.Repository
import org.koin.dsl.module

var dataModule = module {
    single<Repository> {
        RepositoryImpl(get())
    }
}