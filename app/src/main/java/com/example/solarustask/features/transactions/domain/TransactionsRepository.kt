package com.example.solarustask.features.transactions.domain

import com.example.solarustask.core.data.networking.Resource
import kotlinx.coroutines.flow.Flow

interface TransactionsRepository {

    suspend fun getAllTransactions(): Flow<Resource<Transactions>>
}