package com.example.solarustask.features.transactions.data.mappers

import com.example.solarustask.features.transactions.data.TransactionDto
import com.example.solarustask.features.transactions.data.TransactionsResponse
import com.example.solarustask.features.transactions.domain.Transaction
import com.example.solarustask.features.transactions.domain.Transactions


fun TransactionDto.toTransaction()
= Transaction(
    price = price ?: 0.0,
    location = location ?: "",
    timestamp = timestamp ?: ""
)

fun TransactionsResponse.toDomain() = Transactions(
    numOfTotalTrxs = numOfTotalTrxs ?: 0,
    transactions = transactions?.map { it?.toTransaction() ?: Transaction(0.0, "", "") } ?: emptyList()

)