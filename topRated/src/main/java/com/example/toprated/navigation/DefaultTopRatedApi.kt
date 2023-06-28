package com.example.toprated.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.presentation.screens.AppScreens
import com.example.core.utils.FeatureApi
import com.example.toprated.presentation.TopRatedScreen
import javax.inject.Inject

class DefaultTopRatedApi @Inject constructor() : FeatureApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(AppScreens.TopRatedScreen.route) {
            TopRatedScreen(modifier = modifier)
        }
    }
}