package com.example.solarustask.di

import android.content.Context
import androidx.room.Room
import com.example.solarustask.core.data.database.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "app_db"
        ).build()
    }

    @Provides
    fun provideTransactionDao(database: AppDataBase) = database.transactionDao()

}