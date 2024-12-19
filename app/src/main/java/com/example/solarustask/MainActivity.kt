package com.example.solarustask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.rememberNavController
import com.example.solarustask.core.presentation.components.BottomNavBar
import com.example.solarustask.core.presentation.navigation.NavGraph
import com.example.solarustask.ui.theme.SolarusTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            // Set the layout direction to RTL for Arabic text by default
            CompositionLocalProvider( LocalLayoutDirection provides LayoutDirection.Rtl) {
                SolarusTaskTheme {
                    Scaffold(
                        bottomBar = {
                         BottomNavBar(navHostController = navController)
                        }
                    ) {paddingValues->
                        NavGraph(
                            navController = navController,
                            paddingValues = paddingValues
                        )
                    }
                }
            }
        }
    }
}

