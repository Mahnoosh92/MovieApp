package com.example.core.presentation.components

import androidx.compose.runtime.Composable
import com.example.core.data.model.local.AppThemeState
import com.example.core.presentation.ui.theme.MovieAppTheme


@Composable
fun BaseView(
    appThemeState: AppThemeState,
    content: @Composable () -> Unit
) {
    MovieAppTheme(
        darkTheme = appThemeState.isDarkTheme,
        colorPallet = appThemeState.pallet
    ) {
        content()
    }
}