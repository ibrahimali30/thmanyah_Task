package com.ibrahim.thmanyahTask.search.data

import com.ibrahim.thmanyahTask.search.data.model.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRemoteService {

    @GET("search")
    suspend fun getSearchSectionsList(
        @Query("query") query: String
    ): SearchResult
}