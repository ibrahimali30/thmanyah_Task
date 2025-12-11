package com.ibrahim.thmanyahTask.home.data.model

import com.ibrahim.thmanyahTask.home.domain.model.Section
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeMapperTest {

    @Test
    fun `SectionResponse toDomain maps all fields`() {
        val contentItem = ContentItem(
            name = "Item 1",
            description = "desc",
            avatarUrl = "http://avatar",
            duration = 100L
        )

        val response = SectionResponse(
            name = "Home",
            type = SectionType.SQUARE,
            contentType = ContentType.PODCAST,
            order = 1,
            content = listOf(contentItem)
        )

        val domain: Section = response.toDomain()

        assertEquals("Home", domain.name)
        assertEquals(SectionType.SQUARE, domain.type)
        assertEquals(ContentType.PODCAST, domain.contentType)
        assertEquals(1, domain.order)
        assertEquals(listOf(contentItem), domain.content)
    }

    @Test
    fun `List of SectionResponse toDomain maps every element`() {
        val ci1 = ContentItem("A", "d", "a", 1L)
        val ci2 = ContentItem("B", "d2", "b", 2L)

        val responses = listOf(
            SectionResponse("A", SectionType.TWO_LINES_GRID, ContentType.EPISODE, 0, listOf(ci1)),
            SectionResponse("B", SectionType.BIG_SQUARE, ContentType.AUDIO_BOOK, 1, listOf(ci2))
        )

        val domains = responses.toDomain()

        assertEquals(2, domains.size)
        assertEquals("A", domains[0].name)
        assertEquals(SectionType.BIG_SQUARE, domains[1].type)
    }
}

