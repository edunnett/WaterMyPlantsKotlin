package com.example.watermyplants.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun CustomSpacer()
{
    Spacer(androidx.compose.ui.Modifier.height(10.dp).width(10.dp))
}

@Composable
fun HeadingSpacer()
{
    Spacer(androidx.compose.ui.Modifier.height(22.dp).width(10.dp))
}
