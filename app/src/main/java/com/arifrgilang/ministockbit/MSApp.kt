package com.arifrgilang.ministockbit

import android.app.Application
import com.arifrgilang.data.di.dataModule
import com.arifrgilang.data.di.networkModule
import com.arifrgilang.domain.di.domainModule
import com.arifrgilang.ministockbit.di.viewModelModule
import com.orhanobut.hawk.Hawk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MSApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        startKoin{
            androidLogger()
            androidContext(this@MSApp)
            modules(
                    networkModule,
                    viewModelModule,
                    domainModule,
                    dataModule
            )
        }
    }
}