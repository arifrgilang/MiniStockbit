package com.arifrgilang.domain.model

import com.google.gson.annotations.SerializedName

data class DisplayModel (
    @SerializedName("IDR")
    val displayDetail: DisplayDetailModel?
)