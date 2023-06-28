package com.example.mpvieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.core.data.model.local.AppThemeState
import com.example.core.presentation.components.BaseView
import com.example.core.utils.FeatureApi
import com.example.core.utils.HOME_NAVIGATION
import com.example.core.utils.POPULAR_NAVIGATION
import com.example.core.utils.TOP_RATED_NAVIGATION
import com.example.core.utils.UP_COMING_NAVIGATION
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @field:Named(HOME_NAVIGATION)
    lateinit var homeFeatureApi: FeatureApi

    @Inject
    @field:Named(POPULAR_NAVIGATION)
    lateinit var popularFeatureApi: FeatureApi

    @Inject
    @field:Named(TOP_RATED_NAVIGATION)
    lateinit var topRatedFeatureApi: FeatureApi

    @Inject
    @field:Named(UP_COMING_NAVIGATION)
    lateinit var upComingFeatureApi: FeatureApi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val isDark = isSystemInDarkTheme()
            val appThemeState by remember {
                mutableStateOf(AppThemeState(isDarkTheme = isDark))
            }
            BaseView(appThemeState = appThemeState) {
                MainScreen(
                    navController = navController,
                    featureApiList = listOf(
                        homeFeatureApi,
                        popularFeatureApi,
                        topRatedFeatureApi,
                        upComingFeatureApi
                    )
                )
            }
        }
    }
}

