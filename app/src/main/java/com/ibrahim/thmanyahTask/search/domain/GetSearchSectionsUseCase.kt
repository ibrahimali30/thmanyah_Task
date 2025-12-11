package com.ibrahim.thmanyahTask.search.domain

import com.ibrahim.thmanyahTask.home.data.model.SectionResponse
import com.ibrahim.thmanyahTask.search.data.model.SearchSectionResponse
import javax.inject.Inject

class GetSearchSectionsUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(query: String): List<SearchSectionResponse> =
        repository.getSearchSectionsList(query = query)
}