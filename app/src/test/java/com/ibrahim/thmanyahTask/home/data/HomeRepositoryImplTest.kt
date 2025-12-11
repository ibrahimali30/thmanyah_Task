package com.ibrahim.thmanyahTask.home.data

import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.data.model.HomeResult
import com.ibrahim.thmanyahTask.home.data.model.Pagination
import com.ibrahim.thmanyahTask.home.data.model.SectionResponse
import com.ibrahim.thmanyahTask.home.domain.model.Section
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeRepositoryImplTest {

    @Test
    fun `getHomeSectionsList delegates to remoteDS`() = runBlocking {
        var calledWith: Int? = null

        // Dummy service that records the page parameter and returns a minimal HomeResult
        val dummyService = object : HomeRemoteService {
            override suspend fun getHomeSectionsList(page: Int): HomeResult {
                calledWith = page
                return HomeResult(Pagination(null, 0), listOf(
                    SectionResponse("n", com.ibrahim.thmanyahTask.home.data.model.SectionType.SQUARE, com.ibrahim.thmanyahTask.home.data.model.ContentType.PODCAST, page, listOf(ContentItem("name","desc","avatar",1L)))
                ))
            }
        }

        val remoteDS = HomeRemoteDS(dummyService)
        val repo = HomeRepositoryImpl(remoteDS)
        repo.getHomeSectionsList(3)

        assertEquals(3, calledWith)
    }
}
