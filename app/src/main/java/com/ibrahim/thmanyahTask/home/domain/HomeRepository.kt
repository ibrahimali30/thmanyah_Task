package com.ibrahim.thmanyahTask.home.domain

import com.ibrahim.thmanyahTask.home.domain.model.Section

interface HomeRepository {
    suspend fun getHomeSectionsList(page: Int): List<Section>
}