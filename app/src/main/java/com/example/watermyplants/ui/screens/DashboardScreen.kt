package com.example.watermyplants.ui

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
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
import com.example.watermyplants.ui.components.CustomBottomBar
import com.example.watermyplants.ui.components.CustomTopAppBar
import com.example.watermyplants.ui.screens.SettingsScreen
import com.example.watermyplants.ui.screens.StatsScreen
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Preview
@Composable
fun _DashboardScreenPreview() {
    DashboardScreen(rememberAnimatedNavController())
}

@ExperimentalAnimationApi
@Composable
fun DashboardScreen(navController: NavController, selectedIndex: Int? = null) {
    val mySelectedIndex = if (selectedIndex == null) remember { mutableStateOf(0) }
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
                        Box(
                            modifier = Modifier
                                .padding(bottom = 78.dp))
                        {
                            AnimatedVisibility(
                                visible = mySelectedIndex.value == 0,
                                enter = slideInVertically(),
                                exit = fadeOut()
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .animateEnterExit(
                                            // Slide in/out the inner box.
                                            enter = slideInVertically(),
                                            exit = slideOutVertically()
                                        )
                                        .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                                ) {
                                    HomeScreen(navController = navController)

                                }
                            }
                            AnimatedVisibility(
                                visible = mySelectedIndex.value == 1,
                                enter = fadeIn(),
                                exit = fadeOut()
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                                ) {
                                    StatsScreen()
                                }
                            }
                            AnimatedVisibility(
                                visible = mySelectedIndex.value == 2,
                                enter = fadeIn(),
                                exit = fadeOut()
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                                ) {
                                    SettingsScreen()
                                }
                            }
                        }
                    }
                }
            },
            bottomBar = {
                CustomBottomBar(selectedIndex = mySelectedIndex)
            },
        )
    }
}





