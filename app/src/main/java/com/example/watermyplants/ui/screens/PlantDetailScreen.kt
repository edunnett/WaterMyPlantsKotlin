package com.example.watermyplants.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.watermyplants.data.Houseplant
import com.example.watermyplants.ui.components.CustomTopAppBar
import com.example.watermyplants.ui.components.HeadingSpacer
import com.example.watermyplants.R
import com.example.watermyplants.data.HouseplantProvider
import com.example.watermyplants.ui.colorPrimary
import com.example.watermyplants.ui.ghost_white


@Preview
@Composable
fun PlantDetailScreen(@PreviewParameter(HouseplantProvider::class) plant: Houseplant?) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar()
        },
        content = {
            Surface(modifier = Modifier.fillMaxSize(), color = colorPrimary) {
                Card(
                    backgroundColor = ghost_white,
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    modifier = Modifier.fillMaxSize(),
                ) {
                    if (plant != null) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 22.dp)
                        ) {

                            Column {

                                Text(
                                    text = plant.name,
                                    style = TextStyle(
                                        fontFamily = FontFamily(Font((R.font.josefin_sans_semibold))),
                                        fontSize = 28.sp
                                    ),
                                    modifier = Modifier
                                        .padding(horizontal = 22.dp)
                                )
                                HeadingSpacer()
                                Box(
                                    modifier = Modifier
                                        .height(300.dp)
                                        .fillMaxWidth()
                                )
                                {
                                    AsyncImage(
                                        model = plant.imageUrl,
                                        contentDescription = null,
                                        placeholder = painterResource(
                                            id = R.drawable.plant
                                        ),
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()

                                    )
                                }
                                Box() {
                                    HeadingSpacer()
                                    Text(
                                        text = "Status: " + plant.status,
                                        style = TextStyle(
                                            fontStyle = FontStyle.Italic,
                                            fontFamily = FontFamily(Font((R.font.josefin_sans_semibold_italic))),
                                            fontSize = 24.sp
                                        ),
                                        modifier = Modifier
                                            .padding(horizontal = 22.dp)
                                    )
                                }

                            }
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 22.dp)
                        ) {

                            Column {

                                Text(
                                    text = "Plant not Found",
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

                                Text(
                                    text = "Try again",

                                    )

                            }
                        }
                    }
                }
            }
        }
    )
}
