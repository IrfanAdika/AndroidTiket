package com.irfan.datasource.user.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.irfan.datasource.user.remote.api.UserR
import java.util.*

@Entity(tableName = "User")
data class UserL(
    @PrimaryKey val id: Int?,
    val avatarUrl: String?,
    val url: String?,
    val login: String?
) {

    constructor(user: UserR) : this (
        id = user.id,
        avatarUrl = user.avatarUrl,
        url = user.url,
        login = user.login
    )
}