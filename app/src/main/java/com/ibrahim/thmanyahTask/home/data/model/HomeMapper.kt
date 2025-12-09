package com.ibrahim.thmanyahTask.home.data.model

import com.ibrahim.thmanyahTask.home.domain.model.Section


fun SectionResponse.toDomain() = Section(
    name = name,
    type = type,
    contentType = contentType,
    order = order,
    content = content
)

fun List<SectionResponse>.toDomain() = map { it.toDomain() }