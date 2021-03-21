package com.arifrgilang.domain.model

import com.google.gson.annotations.SerializedName

data class RawModel (
    @SerializedName("USD")
    val rawDetail: RawDetailModel?
)
