package com.ibrahim.thmanyahTask.home.domain.model

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.data.model.ContentType
import com.ibrahim.thmanyahTask.home.data.model.SectionType

data class Section(
    val name: String,
    val type: SectionType,
    val contentType: ContentType,
    val order: Int,
    val content: List<ContentItem>,
)