package com.example.albertsonschallenge.model

import com.example.albertsonschallenge.model.remote.SearchAPI
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImplementation constructor(private val searchService: SearchAPI) : Repository {
    override fun getAcronym(
        acronymSearch: String
    ): Flow<UIState> {
        return flow {
            val response = searchService.api.getAcronymList(acronymSearch)
            emit(UIState.Loading())
            delay(600)
            if (response.isSuccessful) {
                response.body()?.let { emit(UIState.Response(it)) } ?: emit(UIState.Empty)
            } else emit(UIState.Error(response.message()))
        }
    }
}