package com.example.solarustask.features.transactions.presentation

import com.example.solarustask.features.transactions.presentation.model.TransactionUi

data class TransactionsState(
    val isLoading: Boolean = false,
    val transactions: List<TransactionUi> = emptyList(),
    val numOfTransactions: Int = 0,
    val error: String? = null
)
