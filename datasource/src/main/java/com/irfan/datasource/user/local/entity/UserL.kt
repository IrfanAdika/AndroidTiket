package com.irfan.datasource.user.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.irfan.datasource.user.remote.api.UserR
import java.util.*

@Entity(tableName = "User")
data class UserL(
    @PrimaryKey val id: Int?,
    val login: String?,
    val nodeId: String?,
    val avatarUrl: String?,
    val gravatarId: String?,
    val url: String?,
    val htmlUrl: String?,
    val followersUrl: String?,
    val followingUrl: String?,
    val gistsUrl: String?,
    val starredUrl: String?,
    val subscriptionUrl: String?,
    val organizatinsUrl: String?,
    val reposUrl: String?,
    val eventsUrl: String?,
    val receivedEventsUrl: String?,
    val type: String?,
    val siteAdmin: Boolean?,
    val score: Double?

) {

    constructor(user: UserR) : this (
        id = user.id,
        login = user.login,
        nodeId = user.nodeId,
        avatarUrl = user.avatarUrl,
        gravatarId = user.gravatarId,
        url = user.url,
        htmlUrl = user.htmlUrl,
        followersUrl = user.followersUrl,
        followingUrl = user.followingUrl,
        gistsUrl = user.gistsUrl,
        starredUrl = user.starredUrl,
        subscriptionUrl = user.subscriptionsUrl,
        organizatinsUrl = user.organizationsUrl,
        reposUrl = user.reposUrl,
        eventsUrl = user.eventsUrl,
        receivedEventsUrl = user.receivedEventsUrl,
        type = user.type,
        siteAdmin = user.siteAdmin,
        score = user.score
    )
}