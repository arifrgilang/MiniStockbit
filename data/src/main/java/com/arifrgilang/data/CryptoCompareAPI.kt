package com.arifrgilang.data

import com.arifrgilang.domain.base.response.ResponseArray
import com.arifrgilang.domain.model.CryptoModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCompareAPI {
    @GET("data/top/totaltoptiervolfull")
    fun getCryptoList(
        @Query("limit") limit: Int,
        @Query("page") pageNum: Int,
        @Query("tsym") tsym: String
    ): Single<ResponseArray<CryptoModel>>
}