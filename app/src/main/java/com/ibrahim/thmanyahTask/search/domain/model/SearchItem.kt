package com.ibrahim.thmanyahTask.search.domain.model

import com.ibrahim.thmanyahTask.home.data.model.ContentItem

data class SearchItem(
    val name: String,
    val type: String,
    val contentType: String,
    val order: String,
    val content: List<ContentItem>,
)