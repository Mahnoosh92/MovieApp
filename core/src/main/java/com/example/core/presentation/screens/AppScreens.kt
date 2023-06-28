package com.example.core.presentation.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.core.R

sealed class AppScreens(
    val route: String,
    @StringRes val title: Int = R.string.generat_title,
    val navIcon: (@Composable () -> Unit) = {
        Icon(
            Icons.Filled.Home, contentDescription = "home"
        )
    },
    val objectName: String = "",
    val objectPath: String = ""
) {
    object HomeScreen : AppScreens(route = "home_screen", title = R.string.home, navIcon = {
        Icon(Icons.Filled.Home, contentDescription = "home")
    })

    object PopularScreen :
        AppScreens(route = "popular_screen", title = R.string.popular, navIcon = {
            Icon(Icons.Filled.BarChart, contentDescription = "popular")
        })

    object TopRatedScreen :
        AppScreens(route = "top_rated_screen", title = R.string.toprated, navIcon = {
            Icon(Icons.Filled.Star, contentDescription = "top_rated")
        })

    object UpComingScreen :
        AppScreens(route = "up_coming_screen", title = R.string.upcoming, navIcon = {
            Icon(Icons.Filled.ArrowDownward, contentDescription = "up_coming")
        })
}