package com.ibrahim.thmanyahTask.home.data

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.data.model.HomeResult
import com.ibrahim.thmanyahTask.home.data.model.Pagination
import com.ibrahim.thmanyahTask.home.data.model.SectionResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class HomeRemoteDSTest {

    @Test
    fun `getHomeSectionsList accumulates pages until nextPage null`() {
        runBlocking {
            // Prepare a sequence of HomeResult responses
            val responses = mutableListOf<HomeResult>()
            val firstSection = SectionResponse(
                "A",
                com.ibrahim.thmanyahTask.home.data.model.SectionType.SQUARE,
                com.ibrahim.thmanyahTask.home.data.model.ContentType.PODCAST,
                0,
                listOf(ContentItem("n", "d", "a", 1L))
            )
            val secondSection = SectionResponse(
                "B",
                com.ibrahim.thmanyahTask.home.data.model.SectionType.BIG_SQUARE,
                com.ibrahim.thmanyahTask.home.data.model.ContentType.EPISODE,
                1,
                listOf(ContentItem("n2", "d2", "a2", 2L))
            )

            responses.add(HomeResult(Pagination(nextPage = "2", totalPages = 2), listOf(firstSection)))
            responses.add(HomeResult(Pagination(nextPage = null, totalPages = 2), listOf(secondSection)))

            var callIndex = 0
            val fakeService = object : HomeRemoteService {
                override suspend fun getHomeSectionsList(page: Int): HomeResult {
                    val resp = responses[callIndex]
                    callIndex++
                    return resp
                }
            }

            val ds = HomeRemoteDS(fakeService)

            val r1 = ds.getHomeSectionsList(1)
            assertEquals(1, r1.size)
            assertEquals("A", r1[0].name)

            val r2 = ds.getHomeSectionsList(2)
            // Should accumulate previous + new
            assertEquals(2, r2.size)
            assertEquals("A", r2[0].name)
            assertEquals("B", r2[1].name)

            // Further calls after nextPage null should return cached list without advancing service
            val r3 = ds.getHomeSectionsList(3)
            assertEquals(2, r3.size)
        }
    }
}
