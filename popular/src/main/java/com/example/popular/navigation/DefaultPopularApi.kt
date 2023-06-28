package com.example.popular.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.presentation.screens.AppScreens
import com.example.core.utils.FeatureApi
import com.example.popular.presentation.PopularScreen
import javax.inject.Inject

class DefaultPopularApi @Inject constructor() : FeatureApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(AppScreens.PopularScreen.route) {
            PopularScreen(modifier = modifier)
        }
    }
}