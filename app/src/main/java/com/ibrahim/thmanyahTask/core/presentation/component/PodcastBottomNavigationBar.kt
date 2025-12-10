package com.ibrahim.thmanyahTask.core.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CollectionsBookmark
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.CollectionsBookmark
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.SavedSearch
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ibrahim.thmanyahTask.R

@Composable
fun PodcastBottomNavigationBar(
    onTabSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
    selectedTab: Int = 0,
) {
    val navigationItems =
        listOf(
            NavigationItem(
                Icons.Rounded.Home,
                Icons.Outlined.Home,
                stringResource(R.string.core_ui_main_label),
            ),
            NavigationItem(
                Icons.Rounded.SavedSearch,
                Icons.Outlined.Search,
                stringResource(R.string.core_ui_search_label),
            ),
            NavigationItem(
                Icons.Rounded.Groups,
                Icons.Outlined.Groups,
                stringResource(R.string.core_ui_community_label),
            ),
            NavigationItem(
                Icons.Rounded.CollectionsBookmark,
                Icons.Outlined.CollectionsBookmark,
                stringResource(R.string.core_ui_library_label),
            ),
            NavigationItem(
                Icons.Rounded.Settings,
                Icons.Outlined.Settings,
                stringResource(R.string.core_ui_settings_label),
            ),
        )
    BottomNavigationBar(
        navigationItems = navigationItems,
        selectedTab = selectedTab,
        onTabSelect = onTabSelect,
        modifier = modifier,
    )
}
