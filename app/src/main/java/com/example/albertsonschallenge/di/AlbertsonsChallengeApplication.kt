package com.example.albertsonschallenge.di

import android.app.Application
import com.example.albertsonschallenge.model.Repository
import com.example.albertsonschallenge.model.RepositoryImplementation
import com.example.albertsonschallenge.model.remote.SearchAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ViewModelComponent

@HiltAndroidApp
class AlbertsonsChallengeApplication: Application()