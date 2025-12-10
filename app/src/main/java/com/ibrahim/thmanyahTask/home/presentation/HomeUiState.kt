package com.ibrahim.thmanyahTask.home.presentation

import com.ibrahim.thmanyahTask.home.domain.model.Section


data class HomeUiState(
    val sections: List<Section> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val isLoadingMore: Boolean = false,
    val error: String? = null,
    val canLoadMore: Boolean = true,
)
