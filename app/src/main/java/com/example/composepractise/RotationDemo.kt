package com.example.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

class RotationDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRotationDemo()
        }
    }
}

@Composable
fun ComposeRotationDemo() {

    var score by remember {
        mutableStateOf(0f)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Black)
    ) {
        val angle: Float by animateFloatAsState(
            targetValue = score,
            animationSpec = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        )

        Canvas(
            modifier = Modifier
                .background(color = Color.Gray)
                .aspectRatio(1f)
                .rotate(angle)
        ) {
            drawLine(
                color = Color.White,
                start = Offset(
                    x = size.width / 2,
                    y = size.height / 2
                ),
                end = Offset(
                    x = size.width / 4,
                    y = size.height / 4
                ),
                strokeWidth = 10f
            )
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .offset(y = 500.dp)
            .background(color = Color.LightGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Button(
            onClick = {
                score = 0f
            },

            ) {
            Text(text = "Reset")
        }

        Button(
            onClick = {
                score = 1000f
            },
        ) {
            Text(text = "Animate")
        }
    }
}