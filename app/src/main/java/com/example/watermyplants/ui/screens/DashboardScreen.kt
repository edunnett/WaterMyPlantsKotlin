package com.example.watermyplants.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.watermyplants.ui.components.CustomBottomBar
import com.example.watermyplants.ui.components.CustomTopAppBar
import com.example.watermyplants.ui.screens.SettingsScreen
import com.example.watermyplants.ui.screens.StatsScreen

@Preview
@Composable
fun _DashboardScreenPreview() {
    DashboardScreen(rememberNavController())
}

@Composable
fun DashboardScreen(navController: NavController, selectedIndex: Int? = null) {
    val mySelectedIndex = if(selectedIndex == null ) remember { mutableStateOf(0) }
    else remember { mutableStateOf(selectedIndex) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CustomTopAppBar()
            },
            content = {
                Surface(modifier = Modifier.fillMaxSize(), color = colorPrimary) {
                    Card(
                        backgroundColor = ghost_white,
                        shape = RoundedCornerShape(topStart = 30.dp),
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Box(modifier = Modifier.padding(bottom = 96.dp)) {
                            when (mySelectedIndex.value) {
                                0 -> {
                                    HomeScreen(navController = navController)
                                }
                                1 -> {
                                    StatsScreen()
                                }
                                2 -> {
                                    SettingsScreen()
                                }
                            }
                        } //bodyContent()

                    }
                }
            },
            bottomBar = {
                CustomBottomBar(selectedIndex = mySelectedIndex)
            },
        )
    }
}





