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

    private var dataItems: MutableList<UserUIModel> = mutableListOf()

    override suspend fun getUser(
        q: String,
        page: Int,
        perPage: Int,
        isSearch: Boolean
    ): Flow<Result<Pagination.Result<UserUIModel>>> =
        flow<Result<Pagination.Result<UserUIModel>>> {
            if (isSearch) {
                dataItems.clear()
            }
            val apiResult = remote.getUser(q, page, 10)
            when (apiResult) {

                is DataResult.Success -> {
                    val userUIModel = apiResult.data.items.map { UserUIModel(it) }

                    dataItems.addAll(userUIModel)

                    // Post Pagination Success
                    emitSuccess(
                        if (isSearch) {
                            Pagination.Result.Replace(newElements = dataItems)
                        } else {
                            Pagination.Result.Append(
                                allElements = dataItems,
                                newPage = userUIModel
                            )
                        }

                    )
                }

                is DataResult.Failure -> emitFailure(apiResult.ex)
            }
        }
}