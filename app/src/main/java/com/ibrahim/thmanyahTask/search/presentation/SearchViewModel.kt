package com.ibrahim.thmanyahTask.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.data.model.ContentType
import com.ibrahim.thmanyahTask.search.domain.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
    @Inject
    constructor(
        private val searchRepository: SearchRepository,
    ) : ViewModel() {
        private val _searchQuery = MutableStateFlow("")
        val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

        private val _selectedContentType = MutableStateFlow<ContentType?>(null)

        private val _searchResults = MutableStateFlow<List<ContentItem>>(emptyList())
        val searchResults: StateFlow<List<ContentItem>> = _searchResults.asStateFlow()

        private val _isLoading = MutableStateFlow(false)
        val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

        private val _error = MutableStateFlow<String?>(null)
        val error: StateFlow<String?> = _error.asStateFlow()

        @OptIn(FlowPreview::class)
        val searchState =
            searchQuery.debounce(300).distinctUntilChanged()


        init {
            // Auto-search when query changes
            viewModelScope.launch {
                searchQuery
                    .debounce(300)
                    .distinctUntilChanged()
                    .collect { query ->
                    if (query.isNotBlank()) {
                        performSearch(query)
                    } else if (query.isBlank()) {
                        _searchResults.value = emptyList()
                        _error.value = null
                    }
                }
            }
        }

        fun updateSearchQuery(query: String) {
            _searchQuery.value = query
        }

        fun selectContentType(contentType: ContentType?) {
            _selectedContentType.value = contentType
        }

        fun searchFromHistory(query: String) {
            _searchQuery.value = query
        }

        fun clearSearch() {
            _searchQuery.value = ""
            _searchResults.value = emptyList()
            _error.value = null
        }

        fun clearSearchHistory() {
            viewModelScope.launch {
//                searchRepository.clearSearchHistory()
            }
        }

        private fun performSearch(query: String) {
            viewModelScope.launch {
                _isLoading.value = true
                _error.value = null

                try {
                    val result = searchRepository.getSearchSectionsList(query)
                    _searchResults.value = result.flatMap { it.content }
                    _error.value = null
                }catch (exception: Exception){
                    exception.printStackTrace()
                    _error.value = "Search failed"
                    _searchResults.value = emptyList()
                }

                _isLoading.value = false
            }
        }

    }
