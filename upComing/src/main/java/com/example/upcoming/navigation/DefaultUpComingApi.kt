package com.example.upcoming.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.presentation.screens.AppScreens
import com.example.core.utils.FeatureApi
import com.example.upcoming.presentation.UpComingScreen
import javax.inject.Inject

class DefaultUpComingApi @Inject constructor() : FeatureApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(AppScreens.UpComingScreen.route) {
            UpComingScreen(modifier = modifier)
        }
    }
}