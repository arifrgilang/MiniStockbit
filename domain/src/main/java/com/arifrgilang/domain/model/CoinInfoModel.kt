package com.arifrgilang.domain.model

import com.google.gson.annotations.SerializedName

data class CoinInfoModel (
    @SerializedName("Algorithm")
    val algorithm: String?,
    @SerializedName("BlockNumber")
    val blockNumber: Int?,
    @SerializedName("BlockReward")
    val blockReward: Double?,
    @SerializedName("BlockTime")
    val blockTime: Double?,
    @SerializedName("DocumentType")
    val documentType: String?,
    @SerializedName("FullName")
    val fullName: String?,
    @SerializedName("Id")
    val id: String?,
    @SerializedName("ImageUrl")
    val imageUrl: String?,
    @SerializedName("Internal")
    val internal: String?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("NetHashesPerSecond")
    val netHashesPerSecond: Double?,
    @SerializedName("ProofType")
    val proofType: String?,
    @SerializedName("Rating")
    val rating: RatingModel?,
    @SerializedName("Type")
    val type: Int?,
    @SerializedName("Url")
    val url: String?
)
