package com.example.watermyplants

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.navArgument
import com.example.watermyplants.data.HouseplantData
import com.example.watermyplants.navigation.Destination
import com.example.watermyplants.ui.DashboardScreen
import com.example.watermyplants.ui.SplashScreen
import com.example.watermyplants.ui.screens.PlantDetailScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@ExperimentalAnimationApi
@Preview
@Composable
fun ComposeApp() {
    val navController = rememberAnimatedNavController()

    MaterialTheme {
        AnimatedNavHost(navController = navController, startDestination = Destination.Splash) {
            composable(Destination.Splash) {
                SplashScreen(navController = navController)
            }
            composable(Destination.Dashboard,
                enterTransition = {
                    fadeIn()
                },
                exitTransition = {
                    fadeOut()

                },
                popEnterTransition = {
                    fadeIn()
                },
                popExitTransition = {
                    fadeOut()
                }
            ) {
                DashboardScreen(navController)
            }
            composable(
                route = "plantDetails" + "/{name}",
                arguments = listOf(navArgument("name") {
                    defaultValue = "Monstera"
                }
                )
            ) { backStackEntry ->

                var plant = HouseplantData.list.filter {
                    it != null && it.name == backStackEntry.arguments?.getString("name")
                }.firstOrNull()

                // You can navigate to a null plant, it will just
                //show an error
                PlantDetailScreen(plant = plant)

            }
        }
    }
}