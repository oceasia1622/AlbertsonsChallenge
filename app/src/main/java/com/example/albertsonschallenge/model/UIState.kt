package com.example.albertsonschallenge.model

import com.example.albertsonschallenge.model.remote.AcronymItem

sealed class UIState {
    data class Response(val success: List<AcronymItem>):UIState()
    data class Error(val errorMessage: String):UIState()
    data class Loading(val loading: Boolean =  true):UIState()
    object Empty: UIState()
}