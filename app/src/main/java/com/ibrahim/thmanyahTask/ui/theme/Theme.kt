package com.ibrahim.thmanyahTask.ui.theme

import android.os.Build
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


@VisibleForTesting
val DarkColorScheme =
    darkColorScheme(
        primary = Pantone7417C, // Button, highlight
        onPrimary = OnDark,
        secondary = Pantone7408C, // Yellow callout
        onSecondary = OnDark,
        background = K100, // Main dark background
        onBackground = OnDark,
        surface = Pantone426C, // Cards or containers
        onSurface = OnDark,
    )

@VisibleForTesting
val LightColorScheme =
    lightColorScheme(
        primary = Pantone7417C, // Primary highlight
        onPrimary = OnLight,
        secondary = Pantone7408C, // Yellow CTA
        onSecondary = OnLight,
        background = PantoneCoolGray1C, // App background
        onBackground = OnLight,
        surface = Color.White, // Containers or cards
        onSurface = OnLight,
    )

@Suppress("ktlint:standard:function-naming")
@Composable
fun ThmanyahTaskTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) {
                    dynamicDarkColorScheme(context)
                } else {
                    dynamicLightColorScheme(context)
                }
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content,
    )
}
