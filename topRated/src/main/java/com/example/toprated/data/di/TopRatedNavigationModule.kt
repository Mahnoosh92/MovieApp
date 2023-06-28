package com.example.toprated.data.di

import com.example.core.utils.FeatureApi
import com.example.core.utils.TOP_RATED_NAVIGATION
import com.example.toprated.navigation.DefaultTopRatedApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class TopRatedNavigationModule {
    @Binds
    @Named(TOP_RATED_NAVIGATION)
    abstract fun provideTopRatedNavigation(defaultTopRatedApi: DefaultTopRatedApi): FeatureApi
}