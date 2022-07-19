package com.example.watermyplants.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.watermyplants.R
import com.example.watermyplants.data.Houseplant
import com.example.watermyplants.data.HouseplantData
import com.example.watermyplants.ui.components.HeadingSpacer

@Preview
@Composable
fun _HomeScreenPreview() {
    HomeScreen(rememberNavController())
}

@Composable
fun HomeScreen(navController:NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp,22.dp,22.dp,0.dp)
    ) {

        Column {

            Text(
                text = "Your Plants",
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily(Font((R.font.josefin_sans_semibold_italic))),
                    fontSize = 24.sp
                )
            )
            HeadingSpacer()
            MyPlantList(navController = navController)
        }
    }
}

@Composable
private fun MyPlantList( navController:NavController) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),

        ) {
        items(HouseplantData.list.size) {
            PlantCard(HouseplantData.list[it],navController = navController)
        }
    }
}

@Composable
private fun PlantCard(plant: Houseplant, navController:NavController) {
    Card(
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable (onClick = {
                navController.navigate("plantDetails/${plant.name}")
            })
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {


            Row(modifier = Modifier.padding(top = 20.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = plant.name,
                        style = TextStyle(
                            color = gray,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                        )
                    )
                    Text(
                        text = plant.status,
                        style = TextStyle(
                            color = colorPrimary,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                        )
                    )
                }

                coil.compose.AsyncImage(
                    model = plant.imageUrl,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.plant
                    ),

                    modifier = Modifier
                        .size(90.dp)

                )

            }
        }
    }
}