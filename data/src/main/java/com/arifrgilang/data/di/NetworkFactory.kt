package com.arifrgilang.data.di

import com.arifrgilang.data.BuildConfig
import com.arifrgilang.data.CryptoCompareAPI
import com.arifrgilang.data.WebSocketAPI
import com.google.gson.GsonBuilder
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.ShutdownReason
import com.tinder.scarlet.websocket.okhttp.OkHttpWebSocket
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkFactory {
    fun provideApiService(
        retrofit: Retrofit.Builder
    ): CryptoCompareAPI = retrofit
        .build()
        .create(CryptoCompareAPI::class.java)

    fun provideScarletService(
        baseUrl: String, apiKey: String
    ) = Scarlet(
        provideOkHttpWebSocket(baseUrl, apiKey),
        provideScarletConfiguration()
    ).create(WebSocketAPI::class.java)

    fun provideRetrofitBuilder(
        baseUrl: String,
        apiKey: String
    ): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(provideOkHttpClient(apiKey))

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }

    private fun provideOkHttpClient(
            apiKey: String
    ) = OkHttpClient.Builder()
        .connectTimeout(DEFAULT_CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
        .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
        .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.MILLISECONDS)
        .addInterceptor(provideHttpLoggingInterceptor())
        .addInterceptor(
            apiKeyInterceptor(apiKey)
        )
        .build()

    private fun apiKeyInterceptor(apiKey: String): Interceptor =
        ApiKeyInterceptor(apiKey)


    private fun provideOkHttpWebSocket(
        baseUrl: String, apiKey: String
    ) = OkHttpWebSocket(
        provideOkHttpClient(apiKey),
        OkHttpWebSocket.SimpleRequestFactory(
            { Request.Builder().url(baseUrl).build() },
            { ShutdownReason.GRACEFUL }
        )
    )

    private fun provideGson() = GsonBuilder()
        .serializeNulls()
        .create()

    private fun provideScarletConfiguration() = Scarlet.Configuration(
        messageAdapterFactories = listOf(GsonMessageAdapter.Factory(provideGson())),
        streamAdapterFactories = listOf(RxJava2StreamAdapterFactory())
    )

    private const val DEFAULT_CONNECT_TIME_OUT: Long = 30 * 1000
    private const val DEFAULT_READ_TIME_OUT: Long = 30 * 1000
    private const val DEFAULT_WRITE_TIME_OUT: Long = 30 * 1000
}