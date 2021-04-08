package com.irfan.datasource.user.remote

import com.irfan.datasource.user.remote.api.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UserWebService {

    @GET("search/users")
    @Headers("Content-Type: application/json")
    suspend fun getUser(@Query("q") q: String, @Query("page") page: Int, @Query("per_page") perPage: Int): UserResponse

}