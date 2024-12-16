package com.example.solarustask.features.transactions.data

import com.example.solarustask.core.networking.Resource
import com.example.solarustask.core.networking.safeApiCall
import com.example.solarustask.features.transactions.data.mappers.toDomain
import com.example.solarustask.features.transactions.domain.Transactions
import com.example.solarustask.features.transactions.domain.TransactionsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionsRepositoryImpl @Inject constructor(private val webServices: WebServices) :
    TransactionsRepository {

    override suspend fun getAllTransactions(): Flow<Resource<Transactions>> {
        return safeApiCall {
            val response = webServices.getTransactions()
            response.toDomain()
        }
    }
}