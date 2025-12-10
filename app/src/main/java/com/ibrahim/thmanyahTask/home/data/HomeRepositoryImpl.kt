package com.ibrahim.thmanyahTask.home.data

import com.ibrahim.thmanyahTask.home.data.model.SectionResponse
import com.ibrahim.thmanyahTask.home.domain.HomeRepository
import com.ibrahim.thmanyahTask.home.domain.model.Section
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val remoteDS: HomeRemoteDS) :
    HomeRepository {

    override suspend fun getHomeSectionsList(page: Int): List<Section> =
        remoteDS.getHomeSectionsList(page)
}