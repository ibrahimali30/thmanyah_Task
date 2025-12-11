package com.ibrahim.thmanyahTask.home.presentation.helper

import org.junit.Assert.assertEquals
import org.junit.Test

class ExtensionFunctionsTest {

    @Test
    fun `formatToDayMonthYear returns formatted date for ISO string`() {
        val input = "2023-05-04T12:34:56Z"
        val expected = "04/05/2023"

        val actual = input.formatToDayMonthYear()

        assertEquals(expected, actual)
    }

    @Test
    fun `formatToDayMonthYear returns empty string for invalid input`() {
        val input = "not-a-date"
        val actual = input.formatToDayMonthYear()
        assertEquals("", actual)
    }
}

