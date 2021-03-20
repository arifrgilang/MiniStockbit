package com.arifrgilang.data.repository

import com.arifrgilang.data.CryptoCompareAPI
import com.arifrgilang.domain.Repository
import com.arifrgilang.domain.base.response.ResponseArray
import com.arifrgilang.domain.model.CryptoModel
import com.arifrgilang.domain.model.CryptoRequestParam
import io.reactivex.Single

class RepositoryImpl(
    private val api: CryptoCompareAPI
) : Repository {
    override fun getCryptoList(
        param: CryptoRequestParam
    ): Single<ResponseArray<CryptoModel>> =
        api.getCryptoList(param.limit, param.pageNum, param.tsym)
}