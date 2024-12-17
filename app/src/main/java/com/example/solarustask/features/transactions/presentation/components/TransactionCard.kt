package com.example.solarustask.features.transactions.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solarustask.R
import com.example.solarustask.features.transactions.presentation.model.TransactionUi
import com.example.solarustask.ui.theme.SolarusTaskTheme

@Composable
fun TransactionCard(
    modifier: Modifier = Modifier,
    transaction: TransactionUi
) {

    Card(
        modifier = modifier
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .fillMaxWidth(.87f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(14.dp),
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            IconText(
                icon = R.drawable.ic_egp,
                text = "${transaction.price}  ج.م",
                iconTint = MaterialTheme.colorScheme.secondary,
                textStyle = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold , color = Color.Black)
            )
            IconText(
                icon = R.drawable.ic_location,
                text = transaction.location,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                IconText(
                    icon = R.drawable.ic_calendar,
                    text = transaction.date,
                )
                IconText(
                    icon = R.drawable.ic_clock,
                    text = transaction.time,
                )
            }
        }

    }

}



@Preview(locale = "ar" , showBackground = true)
@Composable
private fun TransactionCardPreview() {
    SolarusTaskTheme {
        Box(
            modifier = Modifier
                .background(Color(0xFFF4F5F7))
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            TransactionCard(transaction = transactionPrev)
        }
    }
}
val transactionPrev = TransactionUi(
    price = 100.0,
    location = "الجيزه",
    date = "date",
    time = "time"

)