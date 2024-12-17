package com.example.solarustask.core.presentation.navigation

sealed class Screens(val route: String){
    data object Transactions: Screens("transactions")
    data object MyCompanies: Screens("my_companies")
    data object Home: Screens("home")
    data object Policy: Screens("pollicy")
}
