package com.like_magic.gitapp.domain.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UserRepoEntityDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("url")
    val url: String
)