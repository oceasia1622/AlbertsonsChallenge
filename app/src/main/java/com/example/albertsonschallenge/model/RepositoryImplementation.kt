package com.example.albertsonschallenge.model

import com.example.albertsonschallenge.model.remote.SearchAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val searchService: SearchAPI) : Repository {
    override fun getAcronym(
        acronymSearch: String
    ): Flow<UIState> {
        return flow {
            emit(UIState.Loading())
            val response = searchService.api.getAcronymList(acronymSearch)
            if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                response.body()?.let {
                    emit(UIState.Response(it))
                } ?: emit(UIState.Empty)
            } else {
                emit(UIState.Error("Could not find match"))
            }
        }
    }
}