package com.example.albertsonschallenge.model

import com.example.albertsonschallenge.model.remote.SearchResponse

sealed class UIState{
    data class Response(val success: SearchResponse): UIState()
    data class Error(val errorMessage: String): UIState()
    data class Loading(val loading: Boolean = true): UIState()
    object Empty: UIState()
}