package com.example.watermyplants.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val ColorPalette = lightColors(
    primary = colorPrimary,
    primaryVariant = colorPrimary,
    secondary = colorPrimary,
    background = surface_beige,
    surface = surface_beige,
    )

@Composable
fun watermyplantsTheme(content: @Composable() () -> Unit) {

    MaterialTheme(
        colors = ColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}