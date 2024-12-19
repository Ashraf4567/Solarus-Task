package com.example.solarustask.features.transactions.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solarustask.core.presentation.components.ErrorScreen
import com.example.solarustask.core.presentation.components.LoadingScreen
import com.example.solarustask.features.transactions.presentation.components.TransactionsList
import com.example.solarustask.features.transactions.presentation.components.TransactionsTopBar
import com.example.solarustask.features.transactions.presentation.components.transactionsPrev
import com.example.solarustask.ui.theme.SolarusTaskTheme

@Composable
fun TransactionsScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    state: TransactionsState,
    onEvent: (TransactionsEvents) -> Unit
) {

    val minHeight = 100
    val maxHeight = 230

    var topBarHeight by remember { mutableStateOf(maxHeight) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y.toInt()
                val newTopBarHeight = topBarHeight + delta
                val prevTopBarHeight = topBarHeight
                topBarHeight = newTopBarHeight.coerceIn(
                    minHeight,
                    maxHeight
                )
                val consumed = topBarHeight - prevTopBarHeight
                return Offset(0f, consumed.toFloat())
            }
        }
    }


    Column(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {

        if (state.isLoading) {
            LoadingScreen()

        }else if (state.error != null) {
            ErrorScreen(
                message = state.error,
                onRetry = {
                    onEvent(TransactionsEvents.OnRetry)
                }
            )
        }
        else if (state.transactions.isNotEmpty()) {
            TransactionsTopBar(
                modifier = Modifier.height(topBarHeight.dp),
                numOfTransactions = state.numOfTransactions
            )

            TransactionsList(
                transactions = state.transactions
            )
        }

    }

}

@Preview(showBackground = true , locale = "ar")
@Composable
private fun TransactionsScreenPreview() {
    SolarusTaskTheme {
        TransactionsScreen(
            paddingValues = PaddingValues(),
            state = TransactionsState(
                transactions = transactionsPrev
            ),
            onEvent = {}
        )

    }
}