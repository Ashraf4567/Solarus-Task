package com.example.solarustask.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.solarustask.features.transactions.data.offline.TransactionDao
import com.example.solarustask.features.transactions.data.offline.TransactionEntity

@Database(entities = [TransactionEntity::class] , version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
}