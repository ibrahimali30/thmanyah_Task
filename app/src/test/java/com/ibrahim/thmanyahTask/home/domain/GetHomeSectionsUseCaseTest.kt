package com.ibrahim.thmanyahTask.home.domain

import com.ibrahim.thmanyahTask.home.domain.model.Section
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetHomeSectionsUseCaseTest {

    @Test
    fun `invoke calls repository with default page 0`() = runBlocking {
        var calledWith: Int? = null
        val fakeRepo = object : HomeRepository {
            override suspend fun getHomeSectionsList(page: Int): List<Section> {
                calledWith = page
                return emptyList()
            }
        }

        val useCase = GetHomeSectionsUseCase(fakeRepo)
        useCase.invoke()

        assertEquals(0, calledWith)
    }

    @Test
    fun `invoke forwards explicit page parameter`() = runBlocking {
        var calledWith: Int? = null
        val fakeRepo = object : HomeRepository {
            override suspend fun getHomeSectionsList(page: Int): List<Section> {
                calledWith = page
                return emptyList()
            }
        }

        val useCase = GetHomeSectionsUseCase(fakeRepo)
        useCase.invoke(2)

        assertEquals(2, calledWith)
    }
}

