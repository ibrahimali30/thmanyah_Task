package com.ibrahim.thmanyahTask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.ibrahim.thmanyahTask.core.presentation.MainScreenScaffold
import com.ibrahim.thmanyahTask.ui.theme.ThmanyahTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThmanyahTaskTheme() {
                var selectedTab by remember { mutableIntStateOf(0) }

                MainScreenScaffold(
                    selectedTab = selectedTab,
                    onTabSelect = { selectedTab = it },
                )
            }
        }
    }
}
