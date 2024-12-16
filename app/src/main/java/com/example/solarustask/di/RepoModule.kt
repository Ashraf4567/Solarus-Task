package com.example.solarustask.di

import com.example.solarustask.features.transactions.data.TransactionsRepositoryImpl
import com.example.solarustask.features.transactions.domain.TransactionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindTransactionsRepository(
        transactionsRepositoryImpl: TransactionsRepositoryImpl
    ): TransactionsRepository

}