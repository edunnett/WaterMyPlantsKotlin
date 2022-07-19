package com.example.watermyplants.ui

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eco
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.watermyplants.ui.components.CustomSpacer
import com.example.watermyplants.R
import com.example.watermyplants.navigation.Destination
import com.example.watermyplants.ui.colorPrimary
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest


@Preview
@Composable
fun _SplashScreenPreview() {
    SplashScreen(rememberNavController())
}

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
        Animatable(0f)
    }
    val rotation = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 4f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })

        )
        delay(25)
        navController.navigate(Destination.Dashboard)
    }

    // Image
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorPrimary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Filled.Eco,
                tint = Color.White,
                contentDescription = "tb_icon_on"
            )
            CustomSpacer()
            Text(
                text = "Water My Plants",

                color = Color.White,
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily(Font((R.font.josefin_sans_semibold_italic))),
                    fontSize = 24.sp
                )
            )
        }
    }
}
