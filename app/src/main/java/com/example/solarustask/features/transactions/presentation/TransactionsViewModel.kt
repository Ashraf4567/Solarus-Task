package com.example.solarustask.features.transactions.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solarustask.core.data.networking.Resource
import com.example.solarustask.features.transactions.domain.TransactionsRepository
import com.example.solarustask.features.transactions.presentation.model.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val repository: TransactionsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(TransactionsState())
    val state = _state.asStateFlow()
        .onStart {
            getTransactions()
        }.stateIn(
            scope = viewModelScope,
            started = WhileSubscribed(5000),
            initialValue = TransactionsState()
        )

    fun onEvent(event: TransactionsEvents) {
        when (event) {
            TransactionsEvents.OnItemClick -> {}
            TransactionsEvents.OnRetry -> {
                _state.update {
                    it.copy(error = null)
                }
                getTransactions()
            }
        }
    }


    private fun getTransactions() {
        viewModelScope.launch {
            repository.getAllTransactions()
                .collect{res->
                    when(res){
                        is Resource.Error ->{
                            _state.update {
                                it.copy(
                                    error = res.exception.message,
                                    isLoading = false
                                )
                            }
                        }
                        is Resource.Loading -> {
                            _state.update {
                                it.copy(isLoading = true)
                            }
                        }
                        is Resource.ServerError -> {
                            _state.update {
                                it.copy(
                                    error = res.serverError.serverMessage,
                                    isLoading = false
                                )
                            }
                        }
                        is Resource.Success -> {
                            _state.update {
                                it.copy(
                                    transactions = res.data
                                        .transactions.map { transaction ->
                                        transaction.toUi()
                                    },
                                    numOfTransactions = res.data.numOfTotalTrxs,
                                    isLoading = false
                                )
                            }
                        }
                    }
                }
        }
    }

}