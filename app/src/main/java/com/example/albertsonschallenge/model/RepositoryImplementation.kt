package com.example.albertsonschallenge.model

import android.util.Log
import com.example.albertsonschallenge.model.remote.SearchAPI
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val searchService: SearchAPI) : Repository {

    override fun getAcronym(
        acronymSearch: String
    ): Flow<UIState> {
        return flow {
            val response = searchService.api.getAcronymList(acronymSearch)
            emit(UIState.Loading())
            if (response.isSuccessful) {
                Log.d("*****", "getAcronym: Successful")
                response.body()?.let {
                    emit(UIState.Response(it))
                } ?: emit(UIState.Empty)
            } else {
                Log.d("*****", "getAcronym: ERROR")
                emit(UIState.Error(response.message()))
            }
        }
    }
}