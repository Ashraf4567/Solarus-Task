package com.example.solarustask.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ){
        composable(Screens.Home.route){

        }
        composable(Screens.Transactions.route){

        }
        composable(Screens.MyCompanies.route){

        }
        composable(Screens.Policy.route) {

        }
    }
}