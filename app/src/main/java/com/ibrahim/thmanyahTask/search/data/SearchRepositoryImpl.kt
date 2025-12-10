package com.ibrahim.thmanyahTask.search.data

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.search.domain.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val remoteDS: SearchRemoteDS) :
    SearchRepository {

    override suspend fun getSearchSectionsList(query: String): List<ContentItem> =
        remoteDS.getSearchSectionsList(query= query)
}