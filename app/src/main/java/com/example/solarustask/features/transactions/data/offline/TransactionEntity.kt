package com.example.solarustask.features.transactions.data.offline

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey
    val timestamp: String,
    val price: Double?,
    val location: String?
)
