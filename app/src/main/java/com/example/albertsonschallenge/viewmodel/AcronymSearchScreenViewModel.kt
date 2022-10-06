package com.example.albertsonschallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.albertsonschallenge.model.Repository
import com.example.albertsonschallenge.model.UIState
import com.example.albertsonschallenge.model.remote.SearchResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcronymSearchScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _searchState = MutableLiveData<UIState>()
    val searchState: LiveData<UIState> get() = _searchState

    private val _searchResult = MutableLiveData<SearchResponse>()
    val searchResult: LiveData<SearchResponse> get() = _searchResult

    fun searchAcronym(acronym: String) {
        viewModelScope.launch {
            repository.getAcronym(acronym).collect{
                _searchState.postValue(it)
            }
        }
    }
}