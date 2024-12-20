package com.example.solarustask.features.transactions.data.offline

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface TransactionDao {

    @Upsert
    suspend fun upsertTransactions(transactions: List<TransactionEntity>)

    @Query("SELECT * FROM transactions")
    suspend fun getTransactions(): List<TransactionEntity>

}