package com.arifrgilang.domain.model

import com.google.gson.annotations.SerializedName

data class RawModel (
    @SerializedName("IDR")
    val rawDetail: RawDetailModel
)
