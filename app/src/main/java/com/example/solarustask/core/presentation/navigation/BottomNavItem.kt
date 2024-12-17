package com.example.solarustask.core.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomNavItem(
    val route: String,
    @DrawableRes val iconRes: Int,
    @StringRes val labelRes: Int
)