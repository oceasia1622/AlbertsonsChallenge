package com.example.albertsonschallenge.di

import com.example.albertsonschallenge.model.Repository
import com.example.albertsonschallenge.model.RepositoryImplementation
import com.example.albertsonschallenge.model.remote.SearchAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideAcronymApi() = SearchAPI()

    @Singleton
    @Provides
    fun provideRepository(network: SearchAPI): Repository = RepositoryImplementation(network)
}