package com.ibrahim.thmanyahTask.home.data

import com.ibrahim.thmanyahTask.home.data.model.ContentType
import com.ibrahim.thmanyahTask.home.data.model.SectionType
import org.junit.Assert.*
import org.junit.Test

class HomeResponseEnumTest {

    @Test
    fun `SectionType fromKey returns expected enum or null`() {
        assertEquals(SectionType.SQUARE, SectionType.fromKey("square"))
        assertEquals(SectionType.TWO_LINES_GRID, SectionType.fromKey("2_lines_grid"))
        // big_square should map to one of the BIG_SQUARE entries; expect not null
        val big = SectionType.fromKey("big_square")
        assertNotNull(big)
        assertTrue(big == SectionType.BIG_SQUARE || big == SectionType.BIG_SQUARE2)
        assertNull(SectionType.fromKey("unknown_key"))
    }

    @Test
    fun `ContentType fromKey returns expected enum or null`() {
        assertEquals(ContentType.PODCAST, ContentType.fromKey("podcast"))
        assertEquals(ContentType.EPISODE, ContentType.fromKey("episode"))
        assertNull(ContentType.fromKey("invalid"))
    }
}

