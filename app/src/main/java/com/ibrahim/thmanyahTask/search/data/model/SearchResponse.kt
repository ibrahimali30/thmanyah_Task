package com.ibrahim.thmanyahTask.search.data.model

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    val searchItems: List<ContentItem>,
)



