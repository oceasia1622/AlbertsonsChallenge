package com.example.albertsonschallenge.model

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAcronym(acronymSearch: String): Flow<UIState>
}