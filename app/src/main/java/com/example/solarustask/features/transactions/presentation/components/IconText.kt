package com.example.solarustask.features.transactions.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun IconText(
    modifier: Modifier = Modifier,
    icon: Int,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF6A6D7E)),
    iconTint: Color = Color(0xFF6A6D7E)
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            modifier = Modifier.size(14.dp),
            tint = iconTint,
            painter = painterResource(id = icon),
            contentDescription = null,
        )
        Text(
            text = text,
            style = textStyle
        )
    }
}