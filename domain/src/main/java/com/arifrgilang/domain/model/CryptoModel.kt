package com.arifrgilang.domain.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    @SerializedName("CoinInfo")
    var coinInfo: CoinInfoModel,
    @SerializedName("DISPLAY")
    val display: DisplayModel,
    @SerializedName("RAW")
    val raw: RawModel
)
