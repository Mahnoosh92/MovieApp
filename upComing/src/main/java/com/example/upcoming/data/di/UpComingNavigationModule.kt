package com.example.upcoming.data.di

import com.example.core.utils.FeatureApi
import com.example.core.utils.UP_COMING_NAVIGATION
import com.example.upcoming.navigation.DefaultUpComingApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class UpComingNavigationModule {
    @Binds
    @Named(UP_COMING_NAVIGATION)
    abstract fun provideUpComingNavigation(defaultUpcomingApi: DefaultUpComingApi): FeatureApi
}