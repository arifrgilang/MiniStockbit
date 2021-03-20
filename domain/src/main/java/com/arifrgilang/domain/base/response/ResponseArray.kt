package com.arifrgilang.domain.base.response

import com.arifrgilang.domain.model.SponsoredDataModel
import com.google.gson.annotations.SerializedName

data class ResponseArray<Model> (
    @SerializedName("Message")
    var message: String? = "",
    @SerializedName("Type")
    var type: Int,
    @SerializedName("SponsoredData")
    var sponsoredData: List<SponsoredDataModel>? = null,
    @SerializedName("Data")
    var data: List<Model>? = null
)