package com.irfan.home.domain

import com.irfan.core.domain.Result
import com.irfan.core.networking.DataResult
import com.irfan.core.pagination.Pagination
import com.irfan.home.model.UserUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.irfan.core.extensions.emitFailure
import com.irfan.core.extensions.emitSuccess

class UserRepository (
    private val remote: UserDomain.Remote
) : UserDomain.Repository {

    private var currentPage: Int = 0
    private var dataItems: MutableList<UserUIModel> = mutableListOf()

    override suspend fun getUser(
        q: String,
        page: Int,
        perPage: Int
    ) =
        flow<Result<Pagination.Result<UserUIModel>>> {
            val nextPage = currentPage + 1
            val apiResult = remote.getUser(q, page, perPage)
            when (apiResult) {

                is DataResult.Success -> {
                    val movieUiModels = apiResult.data.items.map { UserUIModel(it) }

                    currentPage = 1
                    dataItems.addAll(movieUiModels)

                    // Post Pagination Success
                    emitSuccess(
                        Pagination.Result.Append(
                            allElements = dataItems,
                            newPage = movieUiModels
                        )
                    )
                }

                is DataResult.Failure -> emitFailure(apiResult.ex)
            }
        }
}