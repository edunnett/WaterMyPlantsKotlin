package com.example.watermyplants.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.watermyplants.ui.colorPrimary

@Composable
fun CustomPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorPrimary
        ),
        onClick = onClick,
        modifier = modifier,
        content = content
    )
}

@Composable
fun CustomSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorPrimary
        ),
        onClick = onClick,
        modifier = modifier,
        content = content
    )
}

@Composable
fun RoundedCornerIconButton(modifier: Modifier, icon: Int) {
    Box(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
    ) {
        IconButton(
            onClick = { }, modifier = Modifier
                .align(Alignment.Center)
                .padding(14.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = icon),
                contentDescription = "rounded_corner_icon_button"
            )
        }
    }
}
