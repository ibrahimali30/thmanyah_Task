package com.ibrahim.thmanyahTask.home.presentation

import org.junit.Assert.*
import org.junit.Test

class HomeUiStateTest {

    @Test
    fun `default HomeUiState values`() {
        val state = HomeUiState()
        assertTrue(state.sections.isEmpty())
        assertFalse(state.isLoading)
        assertFalse(state.isLoadingMore)
        assertNull(state.error)
        assertTrue(state.canLoadMore)
    }

    @Test
    fun `copy produces modified instance and keeps original immutable`() {
        val original = HomeUiState()
        val modified = original.copy(isLoading = true, error = "err")

        assertFalse(original.isLoading)
        assertNull(original.error)

        assertTrue(modified.isLoading)
        assertEquals("err", modified.error)
    }
}

