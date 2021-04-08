package com.irfan.home.domain

import com.irfan.core.networking.DataResult
import com.irfan.core.networking.callApi
import com.irfan.datasource.user.remote.UserWebService
import com.irfan.datasource.user.remote.api.UserResponse

class UserRemote (
    private val userWebService: UserWebService
) : UserDomain.Remote {
    override suspend fun getUser(q: String, page: Int, perPage: Int): DataResult<UserResponse> =
        callApi {
            userWebService.getUser(q, page, perPage)
        }


}