package com.arifrgilang.domain

import com.arifrgilang.domain.base.response.ResponseArray
import com.arifrgilang.domain.model.CryptoModel
import com.arifrgilang.domain.model.CryptoRequestParam
import io.reactivex.Single

interface Repository {
    fun getCryptoList(
        param: CryptoRequestParam
    ): Single<ResponseArray<CryptoModel>>
}