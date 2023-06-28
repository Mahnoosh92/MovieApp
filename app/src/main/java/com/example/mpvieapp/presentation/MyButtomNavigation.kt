package com.example.mpvieapp.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.core.presentation.screens.AppScreens

@Composable
fun MyBottomNavigation(
    modifier: Modifier = Modifier,
    bottomList: List<AppScreens>,
    navController: NavHostController,
    onBottomItemClicked: (AppScreens) -> Unit
) {
    BottomNavigation(modifier = modifier) {
        bottomList.forEach {
            BottomNavigationItem(
                selected = currentRoute(navController = navController) == it.route,
                onClick = { onBottomItemClicked(it) },
                label = {
                    Text(
                        text = stringResource(id = it.title),
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                icon =
                    it.navIcon
            )
        }
    }
}