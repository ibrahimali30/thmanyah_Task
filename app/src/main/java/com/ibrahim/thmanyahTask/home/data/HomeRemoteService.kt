package com.ibrahim.thmanyahTask.home.data

import com.ibrahim.thmanyahTask.home.data.model.HomeResult
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeRemoteService {

    @GET("home_sections")
    suspend fun getHome(
        @Query("page") page: Int,
    ): HomeResult
}