package com.example.solarustask.features.transactions.data

import com.example.solarustask.core.data.networking.Resource
import com.example.solarustask.core.data.networking.safeApiCall
import com.example.solarustask.features.transactions.data.mappers.toDomain
import com.example.solarustask.features.transactions.data.mappers.toEntity
import com.example.solarustask.features.transactions.data.offline.TransactionDao
import com.example.solarustask.features.transactions.data.offline.TransactionEntity
import com.example.solarustask.features.transactions.domain.Transactions
import com.example.solarustask.features.transactions.domain.TransactionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TransactionsRepositoryImpl @Inject constructor(
    private val webServices: WebServices,
    private val transactionDao: TransactionDao
) : TransactionsRepository {

    override suspend fun getAllTransactions(): Flow<Resource<Transactions>> = flow {

        safeApiCall {
            val response = webServices.getTransactions()
            response
        }.collect{remoteResult->
            when(remoteResult){
                is Resource.Success -> {
                    val transactionsEntity = remoteResult.data.transactions?.mapNotNull {
                        it?.toEntity()
                    }
                    transactionDao
                        .upsertTransactions(transactionsEntity!!)

                    emit(Resource.Success(remoteResult.data.toDomain()))
                }
                is Resource.Error -> {
                    val localTransactions = transactionDao.getTransactions()
                    if(localTransactions.isNotEmpty()){
                        emit(Resource.Success(Transactions(localTransactions.size , localTransactions.map { it.toDomain() })))
                    }else{
                        emit(Resource.Error(remoteResult.exception))
                    }
                }

                is Resource.Loading -> emit(Resource.Loading())
                is Resource.ServerError -> emit(Resource.ServerError(remoteResult.serverError))
            }
        }


    }
}