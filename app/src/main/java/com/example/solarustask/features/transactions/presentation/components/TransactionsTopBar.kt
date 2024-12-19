package com.example.solarustask.features.transactions.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.solarustask.R
import com.example.solarustask.ui.theme.SolarusTaskTheme

@Composable
fun TransactionsTopBar(
    modifier: Modifier = Modifier,
    numOfTransactions: Int = 73
) {

    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 14.dp,
                    bottomStart = 14.dp
                )
            )
            .padding(top = 24.dp, bottom = 24.dp)
            .height(180.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.manex_logo),
                contentDescription = "logo"
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.num_of_transactions),
                style = MaterialTheme.typography.bodyLarge
                    .copy(color = Color(0xFFC8CAD4))
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "$numOfTransactions  معاملة",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontSize = 35.sp,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        TransactionSearchBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }

}

@Preview(locale = "ar")
@Composable
private fun TransactionsTopBarPreview() {
    SolarusTaskTheme {
        TransactionsTopBar()
    }
}

