package com.example.albertsonschallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.albertsonschallenge.model.Repository
import com.example.albertsonschallenge.model.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AcronymSearchScreenViewModel @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Empty)
    val uiState: StateFlow<UIState> get() = _uiState
    fun searchBook(acronymSearch: String) {
        viewModelScope.launch(dispatcher) {
            repository.getAcronym(acronymSearch).collect { _uiState.value = it }
        }
    }
//    private val _uiState = MutableLiveData<UIState>()
//    val uiState: LiveData<UIState>
//    get() = _uiState
//
//    private val customCoroutineScope = CoroutineScope(Dispatchers.IO)
//
//    init {
//        viewModelScope.launch {
//            repository.getAcronym().collect{
//                _uiState.value = it
//            }
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        customCoroutineScope.cancel()
//    }
}