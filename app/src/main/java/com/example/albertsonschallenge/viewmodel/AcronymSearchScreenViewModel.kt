package com.example.albertsonschallenge.viewmodel

import androidx.lifecycle.*
import com.example.albertsonschallenge.model.Repository
import com.example.albertsonschallenge.model.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcronymSearchScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _searchState = MutableLiveData<UIState>()
    val searchState: LiveData<UIState> get() = _searchState

    fun searchAcronym(acronym: String) {
        viewModelScope.launch {
            repository.getAcronym(acronym).collect{
                _searchState.postValue(it)
            }
        }
    }
}