package com.example.watermyplants.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Grid4x4
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.watermyplants.R
import com.example.watermyplants.ui.chartColors
import com.example.watermyplants.ui.colorPrimary
import com.example.watermyplants.ui.white

@Composable
fun CustomTopAppBar() {
    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth(),
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Water My Plants",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    style = TextStyle(
                        fontFamily = FontFamily(Font((R.font.josefin_sans_semibold))),
                        fontSize = 22.sp
                    )
                )

            }
        },
        backgroundColor = colorPrimary,
    )
}


@Composable
fun CustomBottomBar(selectedIndex: MutableState<Int>) {

    val listItems = listOf("Home", "Stats", "Settings")

    Box(
        modifier = Modifier
            .background(color = chartColors[3])
            .fillMaxWidth()
            .padding(0.dp)
            .height(75.dp)
    ) {
        BottomNavigation(
            backgroundColor = white,
            modifier = Modifier
                .background(color = chartColors[3])
                .fillMaxWidth()
                .padding(0.dp)
                .height(75.dp)
        ) {
            listItems.forEachIndexed { index, _ ->
                val isSelected = selectedIndex.value == index
                BottomNavigationItem(
                    icon = {
                        when (index) {
                            0 -> {
                                TabIcons(
                                    Icons.Filled.Eco,
                                    isSelected
                                )
                            }
                            1 -> {
                                TabIcons(
                                    Icons.Filled.Grid4x4,
                                    isSelected
                                )
                            }
                            2 -> {
                                TabIcons(
                                    Icons.Filled.Settings,
                                    isSelected
                                )
                            }
                        }
                    },
                    selected = isSelected,
                    onClick = {
                        selectedIndex.value = index
                    },

                    alwaysShowLabel = false
                )
            }
        }
    }
}

@Composable
fun TabIcons(icon: ImageVector, isTintColor: Boolean) {
    if (isTintColor) {

        Icon(
            imageVector = icon,
            tint = colorPrimary,
            modifier = Modifier.wrapContentSize(),
            contentDescription = "icon_on"
        )
    } else {
        Icon(
            imageVector = icon,
            modifier = Modifier.wrapContentSize(),
            contentDescription = "icon_off"
        )
    }
}