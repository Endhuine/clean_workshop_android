package com.endhuine.data.api

import com.endhuine.data.dto.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    /**
     * Get a list of [User]
     */
    @GET("users/")
    suspend fun usersGet(): List<User>

    /**
     * Get a [User] by its [id]
     *
     * @param id as the wanted user id
     */
    @GET("users/{id}")
    suspend fun usersGet(@Path("id") id: Int)
}