package com.example.solarustask.features.transactions.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solarustask.core.networking.Resource
import com.example.solarustask.features.transactions.domain.TransactionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val repository: TransactionsRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.getAllTransactions()
                .collect{res->
                    when(res){
                        is Resource.Error ->{
                            Log.d("TransactionsViewModel", "Error: ${res.exception.message}")
                        }
                        is Resource.Loading -> {
                            Log.d("TransactionsViewModel", "Loading")
                        }
                        is Resource.ServerError -> {
                            Log.d("TransactionsViewModel", "ServerError: ${res.serverError.serverMessage}")
                        }
                        is Resource.Success -> {
                            Log.d("TransactionsViewModel", "Success: ${res.data}")
                        }
                    }
                }
        }
    }

}