package com.example.albertsonschallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.albertsonschallenge.model.Repository
import com.example.albertsonschallenge.model.UIState
import com.example.albertsonschallenge.model.remote.AcronymLongforms
import com.example.albertsonschallenge.model.remote.Acronyms
import com.example.albertsonschallenge.model.remote.SearchAPI
import com.example.albertsonschallenge.model.remote.SearchService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AcronymSearchScreenViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    private val _searchResult = MutableLiveData<AcronymLongforms>() // MLDO
    val searchResult: LiveData<AcronymLongforms> // ILDO
        get() = searchResult

    private val _errorMessages = MutableLiveData("") // MLDO
    val errorMessages: LiveData<String> // ILDO
        get() = _errorMessages

    fun searchAcronym(acronym: String) {
        getAcronym(acronym)
            .enqueue(
                object : Callback<AcronymLongforms> {
                    override fun onResponse(
                        call: Call<AcronymLongforms>,
                        response: Response<AcronymLongforms>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                _searchResult.value = it
                            } ?: kotlin.run {
                                _errorMessages.value = response.message()
                            }
                        } else {
                            _errorMessages.value = response.message()
                        }
                    }
                    override fun onFailure(
                        call: Call<AcronymLongforms>,
                        t: Throwable
                    ) {
                        t.printStackTrace()
                        _errorMessages.value = t.message ?: "Unknown error type."
                    }
                }
            )
    }
}
//@HiltViewModel
//class AcronymSearchScreenViewModel @Inject constructor(
//    private val repository: Repository,
//    private val dispatcher: CoroutineDispatcher
//) : ViewModel() {
//    private val _uiState = MutableLiveData<List<AcronymLongforms>>()
//    val uiState: LiveData<List<AcronymLongforms>>
//        get() = _uiState
//
//    private val customCoroutineScope = CoroutineScope(Dispatchers.IO)
//
//    fun searchAcronyms(acronymSearch: String) {
//        viewModelScope.launch(dispatcher) {
//            repository.getAcronym(acronymSearch).collect { _uiState.value }
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        customCoroutineScope.cancel()
//    }
//}