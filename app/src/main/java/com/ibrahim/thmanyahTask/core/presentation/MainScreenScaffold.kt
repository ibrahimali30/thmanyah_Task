package com.ibrahim.thmanyahTask.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ibrahim.thmanyahTask.R
import com.ibrahim.thmanyahTask.core.presentation.component.GreetingSection
import com.ibrahim.thmanyahTask.core.presentation.component.PodcastBottomNavigationBar
import com.ibrahim.thmanyahTask.home.presentation.HomeScreen
import com.ibrahim.thmanyahTask.ui.theme.ThmanyahTaskTheme

@Composable
fun MainScreenScaffold(
    modifier: Modifier = Modifier,
    selectedTab: Int = 0,
    onTabSelect: (Int) -> Unit = {},
) {
    var internalSelectedTab by remember(selectedTab) { mutableIntStateOf(selectedTab) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            PodcastBottomNavigationBar(
                selectedTab = internalSelectedTab,
                onTabSelect = { onTabSelect(it) },
            )
        },
        topBar = {
            GreetingSection(
                greetingText = "${stringResource(R.string.feature_main_good_evening)} Ibrahim ⭐",
            )
        },
    ) { paddingValues ->
        when (selectedTab) {
            0 -> {
                HomeScreen(
                    modifier = Modifier.padding(paddingValues),
                )
            }

            1 -> {
                ToDoScreen()
            }

            else -> {
                ToDoScreen()
            }
        }
    }
}

@Composable
fun ToDoScreen() {
    Box(
        modifier =
            Modifier
                .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "to do screen",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ThmanyahTaskTheme() {
//        PodcastAppWithPlaybackState()
    }
}
