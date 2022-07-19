/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.watermyplants.navigation

import androidx.navigation.NavHostController
//import androidx.navigation.compose.navigate
import com.example.watermyplants.navigation.Destination.Dashboard

/**
 * Models the screens in the app and any arguments they require.
 */
object Destination {
    const val Splash = "Splash"
    const val Dashboard = "Dashboard"
    const val Settings = "Settings"
    const val Stats = "Dashboard"
}

/**
 * Models the navigation actions in the app.
 */
class Actions(navController: NavHostController) {

    val openDashboard: () -> Unit = {
        navController.navigate(Dashboard)
    }

    val addTask: () -> Unit = {
        navController.navigate(Dashboard)
    }

    val upPress: () -> Unit = {
        navController.popBackStack()
    }
}
