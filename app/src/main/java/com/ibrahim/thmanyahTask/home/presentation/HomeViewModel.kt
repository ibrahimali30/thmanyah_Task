package com.ibrahim.thmanyahTask.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.thmanyahTask.home.domain.GetHomeSectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getHomeSectionsUseCase: GetHomeSectionsUseCase
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(HomeUiState())
        val uiState = _uiState.asStateFlow()

        init {
            loadNextPage()
        }

        fun loadNextPage() {
            viewModelScope.launch {
                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true,
                        error = null,
                    )

                try {
                    val homeSections = getHomeSectionsUseCase.invoke()
                    _uiState.value =
                        _uiState.value.copy(
                            sections = homeSections,
                            isLoading = false,
                            error = null,
                        )
                }catch (exception: Exception){
                    _uiState.value =
                        _uiState.value.copy(
                            isLoading = false,
                            error = exception.message ?: "Unknown error occurred",
                        )
                }
            }
        }

        fun checkAndLoadNextPage() {
            val currentState = _uiState.value
            val shouldLoadMore = !currentState.isLoadingMore && currentState.canLoadMore

            if (shouldLoadMore) {
                loadNextPage()
            }
        }

        fun clearError() {
            _uiState.value = _uiState.value.copy(error = null)
        }
    }
