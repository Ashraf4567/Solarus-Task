package com.example.solarustask.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.solarustask.R


val almarai = FontFamily(
    Font(
        resId = R.font.almarai_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.almarai_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.almarai_extrabold,
        weight = FontWeight.ExtraBold
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = almarai,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = almarai,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = almarai,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = almarai,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = almarai,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 17.sp,
    )
)