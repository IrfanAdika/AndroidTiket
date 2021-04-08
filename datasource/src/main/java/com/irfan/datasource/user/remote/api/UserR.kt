package com.irfan.datasource.user.remote.api

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserR(
    @Json(name = "id") val id: Int?,
    @Json(name = "avatar_url") val avatarUrl: String?,
    @Json(name = "url") val url: String?,
    @Json(name = "login") val login: String?
)