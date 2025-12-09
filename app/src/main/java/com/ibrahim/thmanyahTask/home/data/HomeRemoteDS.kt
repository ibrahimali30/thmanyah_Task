package com.ibrahim.thmanyahTask.home.data

import com.ibrahim.thmanyahTask.home.data.model.toDomain
import com.ibrahim.thmanyahTask.home.domain.model.Section
import retrofit2.HttpException
import javax.inject.Inject

class HomeRemoteDS @Inject constructor(private val service: HomeRemoteService) {
    private var page: Int = 1
    private var cachedList: List<Section> = emptyList()
    private var hasNextPage: Boolean = true
    suspend fun getHome(name: String): List<Section> {
        if (!hasNextPage) {
            return cachedList
        }
        val response =
            runCatching { service.getHome(page) }
                .onFailure {
                    if (it is HttpException && it.code() == 404) {
                        noResultFound()
                        return cachedList
                    }
                }.getOrThrow()
        updatePagination(response.pagination.nextPage)
        val result = response.sections.toDomain()
        cachedList = cachedList.plus(result)
        return cachedList
    }

    private fun updatePagination(nextPage: String?) {
        page++
        hasNextPage = nextPage != null
    }

    private fun resetPagination(name: String) {
        page = 1
        cachedList = emptyList()
        hasNextPage = true
    }

    private fun noResultFound() {
        hasNextPage = false
        cachedList = emptyList()
    }
}