package com.example.solarustask.features.transactions.presentation

sealed class TransactionsEvents {
    data object OnRetry : TransactionsEvents()
    data object OnItemClick : TransactionsEvents()
}