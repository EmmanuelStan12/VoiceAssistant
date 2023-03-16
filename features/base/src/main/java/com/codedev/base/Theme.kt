package com.codedev.base

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val ColorPalette = darkColors(
    primary = Colors.ColorPrimary,
    primaryVariant = Colors.ColorPrimary,
    secondary = Colors.ColorSecondary,
    secondaryVariant = Colors.ColorSecondary
)

@Composable
fun BaseAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = ColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}