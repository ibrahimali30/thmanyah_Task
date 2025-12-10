package com.ibrahim.thmanyahTask.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


private val BaseTypography = androidx.compose.material3.Typography()

val AppTypography =
    Typography(
        displayLarge =
            TextStyle(
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 28.sp,
            ),
        displayMedium =
            TextStyle(
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                lineHeight = 26.sp,
            ),
        displaySmall = BaseTypography.displaySmall.copy(fontFamily = IBMPlexSansArabic),
        headlineLarge = BaseTypography.headlineLarge.copy(fontFamily = IBMPlexSansArabic),
        headlineMedium = BaseTypography.headlineMedium.copy(fontFamily = IBMPlexSansArabic),
        headlineSmall = BaseTypography.headlineSmall.copy(fontFamily = IBMPlexSansArabic),
        titleLarge =
            TextStyle(
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 24.sp,
            ),
        titleMedium = BaseTypography.titleMedium.copy(fontFamily = IBMPlexSansArabic),
        titleSmall = BaseTypography.titleSmall.copy(fontFamily = IBMPlexSansArabic),
        bodyLarge =
            TextStyle(
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                lineHeight = 20.sp,
            ),
        bodySmall = BaseTypography.bodySmall.copy(fontFamily = IBMPlexSansArabic),
        labelLarge =
            TextStyle(
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 18.sp,
            ),
        labelMedium = BaseTypography.labelMedium.copy(fontFamily = IBMPlexSansArabic),
        labelSmall =
            TextStyle(
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp,
                lineHeight = 16.sp,
            ),
    )
