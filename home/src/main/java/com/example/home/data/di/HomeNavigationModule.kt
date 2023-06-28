package com.example.home.data.di

import com.example.core.utils.FeatureApi
import com.example.core.utils.HOME_NAVIGATION
import com.example.home.navigation.DefaultHomeApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeNavigationModule {
    @Binds
    @Named(HOME_NAVIGATION)
    abstract fun provideHomeNavigation(defaultHomeApi: DefaultHomeApi): FeatureApi
}