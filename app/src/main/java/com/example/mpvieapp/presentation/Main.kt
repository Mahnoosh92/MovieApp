package com.example.mpvieapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.core.data.model.local.ConnectionState
import com.example.core.presentation.components.SinglePageTopBar
import com.example.core.presentation.screens.AppScreens
import com.example.core.utils.FeatureApi
import com.example.core.utils.connectivityState
import com.example.core.utils.extensions.register
import com.example.mpvieapp.R

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    featureApiList: List<FeatureApi>
) {
    val connection by connectivityState()

    val isConnected = connection === ConnectionState.Available

    Scaffold(modifier = modifier,
        scaffoldState = rememberScaffoldState(),
        topBar = {
            when (currentRoute(navController = navController)) {
//                AppScreens.HomeScreen.route, AppScreens.PopularScreen.route, AppScreens.TopRatedScreen.route, AppScreens.UpComingScreen.route -> {
//                    SinglePageTopBar(title = "") {
//                        navController.navigateUp()
//                    }
//                }
            }
        },
        bottomBar = {
            when (currentRoute(navController = navController)) {
                AppScreens.HomeScreen.route, AppScreens.PopularScreen.route, AppScreens.TopRatedScreen.route, AppScreens.UpComingScreen.route -> {
                    MyBottomNavigation(
                        modifier = modifier,
                        bottomList = listOf(
                            AppScreens.HomeScreen,
                            AppScreens.PopularScreen,
                            AppScreens.TopRatedScreen,
                            AppScreens.UpComingScreen
                        ),
                        navController = navController
                    ) {
                        navController.navigate(it.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                }
            }
        },
        snackbarHost = {
            if (isConnected.not()) {
                Snackbar(
                    action = {}, modifier = modifier.padding(8.dp)
                ) {
                    Text(text = stringResource(R.string.there_is_no_internet))
                }
            }
        }
    ) { paddings ->
        AppGraph(
            modifier = modifier.padding(paddings),
            navController = navController,
            featuresApiList = featureApiList
        )
    }
}

@Composable
fun AppGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    featuresApiList: List<FeatureApi>
) {
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route) {
        featuresApiList.forEach { featureApi ->
            register(featureApi = featureApi, navController = navController, modifier = modifier)
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route?.substringBeforeLast("/")
}
