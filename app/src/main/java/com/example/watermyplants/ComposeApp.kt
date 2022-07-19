package com.example.watermyplants

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.watermyplants.ui.SplashScreen
import com.example.watermyplants.ui.screens.PlantDetailScreen
import com.example.watermyplants.data.HouseplantData
import com.example.watermyplants.navigation.Actions
import com.example.watermyplants.navigation.Destination
import com.example.watermyplants.ui.DashboardScreen

@Preview
@Composable
fun ComposeApp() {
    val navController = rememberNavController()

    val actions = remember(navController) { Actions(navController) }
    MaterialTheme {
        NavHost(navController = navController, startDestination = Destination.Splash) {
            composable(Destination.Splash) {
                SplashScreen(navController)
            }
            composable(Destination.Dashboard) {
                DashboardScreen(navController)
            }
            composable(
                route = "plantDetails" + "/{name}",
                        arguments = listOf(navArgument("name") { defaultValue = "Monstera" })
            ) {
                    backStackEntry ->

                    var plant = HouseplantData.list.filter {
                        it.name == backStackEntry.arguments?.getString("name")
                    }.firstOrNull()

                    // You can navigate to a null plant, it will just
                    //show an error
                    PlantDetailScreen(plant = plant)

            }
        }
    }
}