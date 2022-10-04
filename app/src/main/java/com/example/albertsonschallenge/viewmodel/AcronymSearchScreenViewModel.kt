package com.example.albertsonschallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.albertsonschallenge.model.Repository
import com.example.albertsonschallenge.model.UIState
import com.example.albertsonschallenge.model.remote.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AcronymSearchScreenViewModel@Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _searchResult = MutableLiveData<UIState>()
    val searchResult: LiveData<UIState> get() = _searchResult

    fun searchAcronym(acronym: String) {
        viewModelScope.launch {
            repository.getAcronym(acronym).collect{
                _searchResult.value = it
            }
        }
    }

//    private val _searchResult = MutableLiveData<AcronymItem>()
//    val searchResult: LiveData<AcronymItem> get() = _searchResult
//
//    private val _errorMessages = MutableLiveData("")
//    val errorMessages: LiveData<String> get() = _errorMessages

//    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Empty)
//    val uiState: StateFlow<UIState> get() = _uiState
//
//    fun searchAcronym(acronym: String) {
//        viewModelScope.launch() {
//            repository.getAcronym(acronym)
//                .collect { _uiState.value = it }
//        }
//    }

//    fun searchAcronym(acronym: String) {
//        repository.getAcronym(acronym)
//            .enqueue(
//                object : Callback<AcronymItem> {
//                    override fun onResponse(
//                        call: Call<AcronymItem>,
//                        response: Response<AcronymItem>
//                    ) {
//                        if (response.isSuccessful) {
//                            response.body()?.let {
//                                _searchResult.value = it
//                            } ?: kotlin.run {
//                                _errorMessages.value = response.message()
//                            }
//                        } else {
//                            _errorMessages.value = response.message()
//                        }
//                    }
//                    override fun onFailure(
//                        call: Call<AcronymItem>,
//                        t: Throwable
//                    ) {
//                        t.printStackTrace()
//                        _errorMessages.value = t.message ?: "Unknown error type."
//                    }
//                }
//            )
//    }
}