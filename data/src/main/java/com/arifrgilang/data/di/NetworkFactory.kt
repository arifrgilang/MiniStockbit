package com.arifrgilang.data.di

import com.arifrgilang.data.BuildConfig
import com.arifrgilang.data.CryptoCompareAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkFactory {

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
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

    private fun apiKeyInterceptor(apiKey: String): Interceptor {
        return ApiKeyInterceptor(apiKey)
    }

    fun provideRetrofitBuilder(
            baseUrl: String,
            apiKey: String
    ): Retrofit.Builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(provideOkHttpClient(apiKey))

    fun provideApiService(retrofit: Retrofit.Builder): CryptoCompareAPI =
            retrofit
                    .build()
                    .create(CryptoCompareAPI::class.java)

    private const val DEFAULT_CONNECT_TIME_OUT: Long = 30 * 1000
    private const val DEFAULT_READ_TIME_OUT: Long = 30 * 1000
    private const val DEFAULT_WRITE_TIME_OUT: Long = 30 * 1000
}