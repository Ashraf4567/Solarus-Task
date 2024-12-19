package com.example.solarustask.features.transactions.data

import retrofit2.Response
import retrofit2.http.GET

interface WebServices {

    @GET("getTransactions")
    suspend fun getTransactions(): Response<TransactionsResponse>

}