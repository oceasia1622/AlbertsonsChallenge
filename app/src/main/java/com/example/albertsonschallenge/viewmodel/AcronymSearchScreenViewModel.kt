package com.example.albertsonschallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albertsonschallenge.model.remote.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//@HiltViewModel
//class AcronymSearchScreenViewModel @Inject constructor(
//    private val repository: Repository,
//    private val dispatcher: CoroutineDispatcher
//) : ViewModel() {
//    private val _searchResult = MutableLiveData<AcronymLongforms>()
//    val searchResult: LiveData<AcronymLongforms>
//        get() = _searchResult
//
//    private val customCoroutineScope = CoroutineScope(Dispatchers.IO)
//
//    fun searchAcronym(acronymSearch: String) {
//        viewModelScope.launch(dispatcher) {
//            repository.getAcronym(acronymSearch).collect { _searchResult.value }
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        customCoroutineScope.cancel()
//    }
//}

class AcronymSearchScreenViewModel : ViewModel() {
    private val _searchResult = MutableLiveData<test>()
    val searchResult: LiveData<test>
        get() = _searchResult

    private val _errorMessages = MutableLiveData("")
    val errorMessages: LiveData<String>
        get() = _errorMessages

    fun searchAcronym(acronym: String) {
        SearchAPI.api.getAcronymList(acronym)
            .enqueue(
                object : Callback<test> {
                    override fun onResponse(
                        call: Call<test>,
                        response: Response<test>
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
                        call: Call<test>,
                        t: Throwable
                    ) {
                        t.printStackTrace()
                        _errorMessages.value = t.message ?: "Unknown error type."
                    }
                }
            )
    }
}