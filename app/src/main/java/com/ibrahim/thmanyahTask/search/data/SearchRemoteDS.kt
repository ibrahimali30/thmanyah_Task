package com.ibrahim.thmanyahTask.search.data

import com.ibrahim.thmanyahTask.home.data.model.SectionResponse
import com.ibrahim.thmanyahTask.search.data.model.SearchSectionResponse
import javax.inject.Inject

class SearchRemoteDS @Inject constructor(private val service: SearchRemoteService) {
    suspend fun getSearchSectionsList(query: String): List<SearchSectionResponse> {

        val response = run { service.getSearchSectionsList(query= query) }
        val result = response.searchItems/*.toDomain()*/
        return result
    }

}