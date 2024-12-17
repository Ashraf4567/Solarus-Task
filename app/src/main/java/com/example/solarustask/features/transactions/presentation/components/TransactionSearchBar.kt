package com.example.solarustask.features.transactions.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solarustask.R
import com.example.solarustask.ui.theme.SolarusTaskTheme

@Composable
fun TransactionSearchBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .background(
                color = Color.White
            )
            .padding(horizontal = 12.dp , vertical = 4.dp)
            .fillMaxWidth(.85f)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "فرز المعاملات",
            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary)
        )
    }
}

@Preview(
    showBackground = true,
    locale = "ar"
)
@Composable
private fun TransactionSearchBarPreview(){
    SolarusTaskTheme {
        TransactionSearchBar()
    }
}