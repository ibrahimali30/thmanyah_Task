package com.ibrahim.thmanyahTask.search.data

import com.ibrahim.thmanyahTask.search.data.model.SearchResult
import retrofit2.http.GET

interface SearchRemoteService {

    @GET
    suspend fun getSearchSectionsList(query: String): SearchResult
}