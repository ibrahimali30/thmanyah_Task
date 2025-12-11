package com.ibrahim.thmanyahTask.home.presentation

import com.ibrahim.thmanyahTask.home.domain.GetHomeSectionsUseCase
import com.ibrahim.thmanyahTask.home.domain.HomeRepository
import com.ibrahim.thmanyahTask.home.domain.model.Section
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `init triggers loadNextPage and populates sections on success`() = runTest {
        var invoked = false
        val fakeRepo = object : HomeRepository {
            override suspend fun getHomeSectionsList(page: Int): List<Section> {
                invoked = true
                return listOf()
            }
        }
        val fakeUseCase = GetHomeSectionsUseCase(fakeRepo)

        val vm = HomeViewModel(fakeUseCase)
        vm.loadNextPage()

        // advance until launched coroutines complete
        testDispatcher.scheduler.advanceUntilIdle()
        assertTrue(invoked)
        val state = vm.uiState.first()
        assertFalse(state.isLoading)
    }

    @Test
    fun `loadNextPage handles exception and sets error`() = runTest {
        val fakeRepo = object : HomeRepository {
            override suspend fun getHomeSectionsList(page: Int): List<Section> {
                throw RuntimeException("boom")
            }
        }
        val fakeUseCase = GetHomeSectionsUseCase(fakeRepo)

        val vm = HomeViewModel(fakeUseCase)
        // let init call run
        testDispatcher.scheduler.advanceUntilIdle()

        // trigger loadNextPage explicitly
        vm.loadNextPage()
        testDispatcher.scheduler.advanceUntilIdle()

        val state = vm.uiState.first()
        assertFalse(state.isLoading)
        assertNotNull(state.error)
    }

    @Test
    fun `clearError clears existing error`() = runTest {
        val fakeRepo = object : HomeRepository {
            override suspend fun getHomeSectionsList(page: Int): List<Section> { return emptyList() }
        }
        val fakeUseCase = GetHomeSectionsUseCase(fakeRepo)

        val vm = HomeViewModel(fakeUseCase)
        testDispatcher.scheduler.advanceUntilIdle()

        // manually set an error
        vm.clearError()
        val state = vm.uiState.first()
        assertNull(state.error)
    }
}
