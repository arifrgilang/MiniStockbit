package com.arifrgilang.domain.model

import com.google.gson.annotations.SerializedName

data class Subscribe(
    @SerializedName("action")
    var action: String,
    @SerializedName("subs")
    var subs: List<String>
)