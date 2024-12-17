package com.example.solarustask.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.solarustask.R
import com.example.solarustask.core.presentation.navigation.BottomNavItem
import com.example.solarustask.core.presentation.navigation.Screens
import com.example.solarustask.ui.theme.SolarusTaskTheme


@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    val currentRoute = navHostController.currentBackStackEntryAsState().value?.destination?.route

    Row(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        bottomNavItems.forEach { item->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navHostController.navigate(item.route){
                        popUpTo(navHostController.graph.startDestinationId)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = stringResource(id = item.labelRes),
                        tint = if (currentRoute == item.route) MaterialTheme.colorScheme.primary else Color(0xFF9CA0B0)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.labelRes),
                        style = MaterialTheme.typography.labelMedium,
                        color = if (currentRoute == item.route) MaterialTheme.colorScheme.primary else Color(0xFF9CA0B0)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
val bottomNavItems = listOf(
    BottomNavItem(
        route = Screens.Home.route,
        iconRes = R.drawable.ic_home,
        labelRes = R.string.home
    ),
    BottomNavItem(
        route = Screens.Transactions.route,
        iconRes = R.drawable.ic_transactions,
        labelRes = R.string.transactions
    ),
    BottomNavItem(
        route = Screens.MyCompanies.route,
        iconRes = R.drawable.ic_companies,
        labelRes = R.string.my_companies
    ),
    BottomNavItem(
        route = Screens.Policy.route,
        iconRes = R.drawable.ic_policies,
        labelRes = R.string.policy
    )
)


@Preview(locale = "ar")
@Composable
private fun BottomNavBarPreview() {
    SolarusTaskTheme {
        BottomNavBar(navHostController = NavHostController(LocalContext.current))

    }
}