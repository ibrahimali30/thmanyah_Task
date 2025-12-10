package com.ibrahim.thmanyahTask.search.domain

import com.ibrahim.thmanyahTask.home.data.model.ContentItem

interface SearchRepository {
    suspend fun getSearchSectionsList(query: String): List<ContentItem>
}