package com.example.solarustask.features.transactions.data

import com.google.gson.annotations.SerializedName

data class TransactionsResponse(

	@field:SerializedName("numOfTotalTrxs")
	val numOfTotalTrxs: Int? = null,

	@field:SerializedName("transactions")
	val transactions: List<TransactionDto?>? = null
)

