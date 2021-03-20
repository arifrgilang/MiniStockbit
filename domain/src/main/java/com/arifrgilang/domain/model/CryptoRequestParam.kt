package com.arifrgilang.domain.model

data class CryptoRequestParam (
    var pageNum: Int,
    var limit: Int = 10,
    var tsym: String = "IDR"
)