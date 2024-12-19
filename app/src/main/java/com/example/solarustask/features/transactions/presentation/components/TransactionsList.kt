package com.example.solarustask.features.transactions.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solarustask.features.transactions.presentation.model.TransactionUi
import com.example.solarustask.ui.theme.SolarusTaskTheme

@Composable
fun TransactionsList(
    modifier: Modifier = Modifier,
    transactions: List<TransactionUi>
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        items(transactions) {transaction ->
            TransactionCard(transaction = transaction)
        }

    }

}

@Preview(locale = "ar" , showBackground = true)
@Composable
private fun TransactionsListPreview() {



    SolarusTaskTheme {
        TransactionsList(transactions = transactionsPrev)
    }
}
val transactionsPrev = List(10) {
    transactionPrev
}