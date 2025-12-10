package com.ibrahim.thmanyahTask.search.data

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.data.model.toDomain
import com.ibrahim.thmanyahTask.home.domain.model.Section
import com.ibrahim.thmanyahTask.search.data.model.SearchResult
import javax.inject.Inject

class SearchRemoteDS @Inject constructor(private val service: SearchRemoteService) {
    suspend fun getSearchSectionsList(query: String): List<ContentItem> {

        val response = run { service.getSearchSectionsList(query= query) }
        val result = response.searchItems/*.toDomain()*/
        return result
    }

}