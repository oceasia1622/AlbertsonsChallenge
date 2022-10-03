package com.example.albertsonschallenge.model

import com.example.albertsonschallenge.model.remote.Acronyms

sealed class UIState {
    data class Response(val success: List<Acronyms>):UIState()
    data class Error(val errorMessage: String):UIState()
    data class Loading(val loading: Boolean =  true):UIState()
    object Empty: UIState()
}