package com.example.solarustask.core.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.solarustask.features.transactions.presentation.TransactionsScreen
import com.example.solarustask.features.transactions.presentation.TransactionsViewModel

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ){
        composable(Screens.Home.route){

        }
        composable(Screens.Transactions.route){
            val transactionsViewModel = hiltViewModel<TransactionsViewModel>()
            val state by transactionsViewModel.state.collectAsState()
            TransactionsScreen(
                state = state,
                paddingValues = paddingValues,
                onEvent = transactionsViewModel::onEvent
            )
        }
        composable(Screens.MyCompanies.route){

        }
        composable(Screens.Policy.route) {

        }
    }
}