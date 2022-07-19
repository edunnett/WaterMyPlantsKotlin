package com.example.watermyplants.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.watermyplants.ui.components.CustomSpacer
import com.example.watermyplants.ui.components.HeadingSpacer
import com.example.watermyplants.R
import com.example.watermyplants.data.HouseplantData
import com.example.watermyplants.ui.chartColors
import me.bytebeats.views.charts.pie.PieChart
import me.bytebeats.views.charts.pie.PieChartData
import me.bytebeats.views.charts.pie.render.SimpleSliceDrawer
import me.bytebeats.views.charts.simpleChartAnimation


@Preview
@Composable
fun StatsScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp,22.dp,22.dp,0.dp)
    ) {

        Column {

            Text(
                text = "Plant Stats",
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
                PieChartView()
            }
            LegendView()
        }
    }

}

@Composable
fun LegendView() {
    Column() {
        Row()
        {
            Box(
                Modifier
                    .background(color = chartColors[0])
                    .width(30.dp)
                    .height(20.dp)
            )
            CustomSpacer()
            Text(text = "Healthy")
        }
        CustomSpacer()
        Row()
        {
            Box(
                Modifier
                    .background(color = chartColors[1])
                    .width(30.dp)
                    .height(20.dp)
            )
            CustomSpacer()
            Text(text = "Alive")
        }
        CustomSpacer()
        Row()
        {
            Box(
                Modifier
                    .background(color = chartColors[2])
                    .width(30.dp)
                    .height(20.dp)
            )
            CustomSpacer()
            Text(text = "Barely Alive")
        }
        CustomSpacer()
        Row()
        {
            Box(
                Modifier
                    .background(color = chartColors[3])
                    .width(30.dp)
                    .height(20.dp)
            )
            CustomSpacer()
            Text(text = "Dead")
        }
    }
}

@Composable
fun PieChartView() {

    PieChart(
        pieChartData = PieChartData(
            slices = listOf(
                PieChartData.Slice(
                    HouseplantData.list.filter { it.status == "Alive" }.size.toFloat(),
                    chartColors[0]
                ),
                PieChartData.Slice(
                    HouseplantData.list.filter { it.status == "Healthy" }.size.toFloat(),
                    chartColors[1]
                ),
                PieChartData.Slice(
                    HouseplantData.list.filter { it.status == "Almost Dead" }.size.toFloat(),
                    chartColors[2]
                ),
                PieChartData.Slice(
                    HouseplantData.list.filter { it.status == "Dead" }.size.toFloat(),
                    chartColors[3]
                )
            )
        ),
        // Optional properties.
        modifier = Modifier.fillMaxSize(),
        animation = simpleChartAnimation(),
        sliceDrawer = SimpleSliceDrawer()
    )
}

