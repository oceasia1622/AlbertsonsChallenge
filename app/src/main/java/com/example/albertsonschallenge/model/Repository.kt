package com.example.albertsonschallenge.model

import com.example.albertsonschallenge.model.remote.SearchResponse
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAcronym(acronymSearch: String): Flow<UIState>
}