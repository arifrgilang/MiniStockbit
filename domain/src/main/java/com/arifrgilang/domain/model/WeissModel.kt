package com.arifrgilang.domain.model

import com.google.gson.annotations.SerializedName

data class WeissModel(
    @SerializedName("MarketPerformanceRating")
    val marketPerformanceRating: String,
    @SerializedName("Rating")
    val rating: String,
    @SerializedName("TechnologyAdoptionRating")
    val technologyAdoptionRating: String
)