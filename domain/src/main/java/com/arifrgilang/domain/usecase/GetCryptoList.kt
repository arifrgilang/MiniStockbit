package com.arifrgilang.domain.usecase

import com.arifrgilang.domain.Repository
import com.arifrgilang.domain.SingleUseCase
import com.arifrgilang.domain.base.response.ResponseArray
import com.arifrgilang.domain.model.CryptoModel
import com.arifrgilang.domain.model.CryptoRequestParam
import io.reactivex.Single

class GetCryptoList(
    private val repository: Repository
) : SingleUseCase<ResponseArray<CryptoModel>, CryptoRequestParam>() {
    override fun buildSingleUseCase(params: CryptoRequestParam): Single<ResponseArray<CryptoModel>> =
        repository.getCryptoList(params)
}