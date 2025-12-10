package com.ibrahim.thmanyahTask.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastCircularProgressIndicator
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastTabRow
import com.ibrahim.thmanyahTask.home.presentation.bigsquaresection.BigSquareSection
import com.ibrahim.thmanyahTask.home.presentation.helper.HelperUiObjects
import com.ibrahim.thmanyahTask.home.presentation.squaresection.SquareSection
import com.ibrahim.thmanyahTask.home.presentation.twolinessection.TwoLinesGridSection
import com.ibrahim.thmanyahTask.R
import com.ibrahim.thmanyahTask.core.presentation.component.ErrorScreen
import com.ibrahim.thmanyahTask.core.presentation.component.LoadingScreen
import com.ibrahim.thmanyahTask.core.presentation.utils.PaginationHandler
import com.ibrahim.thmanyahTask.home.data.model.ContentItem
import com.ibrahim.thmanyahTask.home.data.model.SectionType

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onContentClick: (ContentItem) -> Unit = {},
) {
    val context = LocalContext.current

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()
    val snackbarHostState = remember { SnackbarHostState() }
    var selectedTab by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        viewModel.loadNextPage()
    }

    PaginationHandler(listState) {
        viewModel.checkAndLoadNextPage()
    }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
    ) {
        if (uiState.isLoading && uiState.sections.isEmpty()) {
            LoadingScreen(modifier = Modifier.fillMaxSize())
        } else if (!uiState.error.isNullOrBlank() && uiState.sections.isEmpty()) {
            ErrorScreen(
                message = stringResource(R.string.feature_main_loading_failed),
                onRetry = {
                    viewModel.loadNextPage()
                },
                modifier = Modifier.fillMaxSize(),
            )
        } else {
            uiState.sections.let { sections ->
                LazyColumn(
                    state = listState,
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(bottom = 100.dp),
                ) {
                    item {
                        PodcastTabRow(
                            items =
                                HelperUiObjects.getFilterChipStrings(context)
                                    .mapIndexed { index, text ->
                                        index to text
                                    },
                            selectedItem = selectedTab,
                            onItemSelect = { selectedTab = it },
                            modifier =
                                Modifier
                                    .padding(horizontal = 16.dp)
                                    .padding(bottom = 16.dp),
                        )
                    }

                    sections.firstOrNull { it.type == SectionType.QUEUE }?.content?.firstOrNull()
                        ?.let { featuredItem ->
                            item {
                                // This is the queue section featured content
                                FeaturedContentCard(
                                    contentItem = featuredItem,
                                    onClick = onContentClick,
                                )
                            }
                        }

                    // Returns a list of sections ordered by their `order` value.
                    // Each section's `content` is also sorted by `podcastPriority`.
                    // Sections with empty content are excluded from the result.
                    val orderedSections =
                        sections
                            .map { section ->
                                section.copy(content = section.content.sortedBy { it.podcastPriority })
                            }
                            .filter { it.content.isNotEmpty() }
                            .sortedBy { it.order }

                    // Render all sections
                    items(orderedSections) { section ->
                        when (section.type) {
                            SectionType.SQUARE -> {
                                SquareSection(
                                    section = section,
                                    onContentClick = onContentClick,
                                )
                            }

                            SectionType.TWO_LINES_GRID -> {
                                TwoLinesGridSection(
                                    section = section,
                                    onContentClick = onContentClick,
                                )
                            }

                            SectionType.BIG_SQUARE, SectionType.BIG_SQUARE2 -> {
                                BigSquareSection(
                                    section = section,
                                    onContentClick = onContentClick,
                                )
                            }

                            else -> {
                            }
                        }
                    }

                    if (uiState.isLoadingMore) {
                        item {
                            Box(
                                modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                contentAlignment = Alignment.Center,
                            ) {
                                PodcastCircularProgressIndicator()
                            }
                        }
                    }
                }
            }
        }
    }

    // Show error message
    uiState.error?.let { error ->
        LaunchedEffect(error) {
            if (uiState.sections.isNotEmpty()) {
                snackbarHostState.showSnackbar(
                    message = error,
                )
            }
        }
    }
}
