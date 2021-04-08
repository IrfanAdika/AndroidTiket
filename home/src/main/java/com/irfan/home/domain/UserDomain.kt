package com.irfan.home.domain

import com.irfan.core.domain.Result
import com.irfan.core.networking.DataResult
import com.irfan.core.pagination.Pagination
import com.irfan.datasource.user.remote.api.UserResponse
import com.irfan.home.model.UserUIModel
import kotlinx.coroutines.flow.Flow

interface UserDomain {

    interface Repository {
        suspend fun getUser(q: String = "", page: Int = 1, perPage: Int = 100): Flow<Result<Pagination.Result<UserUIModel>>>
    }

    interface Remote {
        suspend fun getUser(q: String = "", page: Int = 1, perPage: Int = 100): DataResult<UserResponse>
    }
}