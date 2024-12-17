package com.example.solarustask

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.rememberNavController
import com.example.solarustask.core.presentation.components.BottomNavBar
import com.example.solarustask.core.presentation.navigation.NavGraph
import com.example.solarustask.features.transactions.presentation.components.TransactionCard
import com.example.solarustask.features.transactions.presentation.components.transactionPrev
import com.example.solarustask.ui.theme.SolarusTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            CompositionLocalProvider( LocalLayoutDirection provides LayoutDirection.Rtl) {
                SolarusTaskTheme {
                    Scaffold(
                        bottomBar = {
                         BottomNavBar(navHostController = navController)
                        }
                    ) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

