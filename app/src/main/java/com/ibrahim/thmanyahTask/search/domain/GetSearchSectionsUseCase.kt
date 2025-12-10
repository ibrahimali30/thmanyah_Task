package com.ibrahim.thmanyahTask.search.domain

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import javax.inject.Inject

class GetSearchSectionsUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(query: String): List<ContentItem> =
        repository.getSearchSectionsList(query = query)
}