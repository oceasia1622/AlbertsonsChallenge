package com.example.albertsonschallenge.di.module

import com.example.albertsonschallenge.model.remote.SearchAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Provides
    fun provideAcronymApi() = SearchAPI()
}