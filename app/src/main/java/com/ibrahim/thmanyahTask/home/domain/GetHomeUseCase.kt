package com.ibrahim.thmanyahTask.home.domain

import com.ibrahim.thmanyahTask.home.domain.model.Section
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(query: String = ""): List<Section> =
        repository.getHome(query)
}