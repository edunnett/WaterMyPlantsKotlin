package com.example.watermyplants.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.watermyplants.ui.components.HeadingSpacer
import com.example.watermyplants.R

@Preview
@Composable
fun SettingsScreen() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp,22.dp,22.dp,0.dp)
    ) {

        Column {

            Text(
                text = "Settings",
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily(Font((R.font.josefin_sans_semibold_italic))),
                    fontSize = 24.sp
                )
            )
            HeadingSpacer()
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .padding(all = 10.dp)

            )
            {
                Text(text = "No settings yet")
            }
        }
    }
}