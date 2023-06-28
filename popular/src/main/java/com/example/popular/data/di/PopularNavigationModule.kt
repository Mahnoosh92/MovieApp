package com.example.popular.data.di

import com.example.core.utils.FeatureApi
import com.example.core.utils.POPULAR_NAVIGATION
import com.example.popular.navigation.DefaultPopularApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class PopularNavigationModule {
    @Binds
    @Named(POPULAR_NAVIGATION)
    abstract fun providePopularNavigation(defaultPopularApi: DefaultPopularApi): FeatureApi
}