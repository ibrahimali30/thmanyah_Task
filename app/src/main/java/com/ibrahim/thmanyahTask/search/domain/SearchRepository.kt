package com.ibrahim.thmanyahTask.search.domain

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.data.model.SectionResponse
import com.ibrahim.thmanyahTask.search.data.model.SearchSectionResponse

interface SearchRepository {
    suspend fun getSearchSectionsList(query: String): List<SearchSectionResponse>
}