package com.ibrahim.thmanyahTask.search.presentation

import com.ibrahim.thmanyahTask.home.domain.model.Section


data class SearchUiState(
    val sections: List<Section> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val query: String = "",
)
