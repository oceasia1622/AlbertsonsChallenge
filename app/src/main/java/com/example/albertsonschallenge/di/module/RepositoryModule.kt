package com.example.albertsonschallenge.di.module

import com.example.albertsonschallenge.model.Repository
import com.example.albertsonschallenge.model.RepositoryImplementation
import com.example.albertsonschallenge.model.remote.SearchAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideRepository(network: SearchAPI): Repository = RepositoryImplementation(network)
}