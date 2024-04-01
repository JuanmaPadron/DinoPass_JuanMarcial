package com.example.rjgames.data.remote.dto.game


import com.google.gson.annotations.SerializedName

data class GamePlatform(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)