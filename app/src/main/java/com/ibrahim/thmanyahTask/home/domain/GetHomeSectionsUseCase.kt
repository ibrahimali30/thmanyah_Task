package com.ibrahim.thmanyahTask.home.domain

import com.ibrahim.thmanyahTask.home.domain.model.Section
import javax.inject.Inject

class GetHomeSectionsUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(page: Int = 0): List<Section> =
        repository.getHomeSectionsList(page)
}