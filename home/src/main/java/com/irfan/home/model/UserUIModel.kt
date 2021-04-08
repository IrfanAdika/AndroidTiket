package com.irfan.home.model

import android.os.Parcelable
import com.irfan.core.pagination.PaginatedItem
import com.irfan.datasource.user.remote.api.UserR
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserUIModel(
    val id: String,
    val avatar: String?,
    val url: String?,
    val login: String?

) : PaginatedItem, Parcelable {

    constructor(user: UserR) : this(
        id = user.id.toString(),
        avatar = user.avatarUrl,
        url = user.url,
        login = user.login
    )
}
