package com.ibrahim.thmanyahTask.home.data

import com.ibrahim.thmanyahTask.home.data.model.toDomain
import com.ibrahim.thmanyahTask.home.domain.model.Section
import javax.inject.Inject

class HomeRemoteDS @Inject constructor(private val service: HomeRemoteService) {
    private var page: Int = 1
    private var homeSectionsList: List<Section> = emptyList()
    private var hasNextPage: Boolean = true
    suspend fun getHomeSectionsList(page: Int): List<Section> {
        if (!hasNextPage) {
            return homeSectionsList
        }
        val response = run { service.getHomeSectionsList(page) }
        updatePagination(response.pagination.nextPage)
        val result = response.sections.toDomain()
        homeSectionsList = homeSectionsList.plus(result)
        return homeSectionsList
    }

    private fun updatePagination(nextPage: String?) {
        page++
        hasNextPage = nextPage != null
    }

    private fun noResultFound() {
        hasNextPage = false
        homeSectionsList = emptyList()
    }
}