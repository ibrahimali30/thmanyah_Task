package com.ibrahim.thmanyahTask.search.data.model

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("sections")
    val searchItems: List<SearchSectionResponse>,
)


@Serializable
data class SearchSectionResponse(
    val name: String,
    val type: String,
    @SerialName("content_type")
    val contentType: String,
    val order: String,
    val content: List<ContentItem>,
)



