package com.example.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.presentation.screens.AppScreens
import com.example.core.utils.FeatureApi
import com.example.home.presentation.HomeScreen
import javax.inject.Inject

class DefaultHomeApi @Inject constructor() : FeatureApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(AppScreens.HomeScreen.route) {
            HomeScreen(modifier = modifier)
        }
    }
}