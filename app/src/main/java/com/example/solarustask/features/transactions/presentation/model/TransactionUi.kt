package com.example.solarustask.features.transactions.presentation.model


import com.example.solarustask.core.presentation.util.formatDateAndTime
import com.example.solarustask.features.transactions.domain.Transaction

data class TransactionUi(
    val price: Double,
    val location: String,
    val date: String,
    val time: String
)

fun Transaction.toUi(): TransactionUi = TransactionUi(
    price = price,
    location = location,
    date = formatDateAndTime(timestamp).first,
    time = formatDateAndTime(timestamp).second
)
