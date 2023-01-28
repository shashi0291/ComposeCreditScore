package com.example.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CreditScoreActivity : ComponentActivity() {

    private val creditScoreViewModel: CreditScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.Black
                    ),
                contentAlignment = Alignment.Center
            ) {
                CreditScoreBar(creditScoreViewModel)
            }

            ComposeButtons(creditScoreViewModel)
        }
    }
}

@Composable
fun CreditScoreBar(
    viewModel: CreditScoreViewModel
) {
    val creditScoreUiState by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .width(380.dp)
            .height(380.dp)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {

//        score arc
        Canvas(
            modifier = Modifier
                .width(330.dp)
                .height(330.dp)
        ) {
            val brush = Brush.horizontalGradient(
                listOf(
                    Color.Red, Color.Yellow, Color.Green
                )
            )
            drawArc(
                brush = brush,
                startAngle = 0f,
                sweepAngle = -180f,
                useCenter = false,
                style = Stroke(
                    width = 100f
                )
            )
        }

//        small arc and line
        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            val angle: Float by animateFloatAsState(
                targetValue = creditScoreUiState.rotationPercent.toFloat(),
                animationSpec = tween(
                    durationMillis = 200,
                    easing = LinearEasing
                )
            )

            Canvas(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .rotate(angle)
            ) {
                drawArc(
                    color = Color.White,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = true,
                    size = Size(width = 40f, height = 40f)
                )

                drawLine(
                    color = Color.White,
                    start = Offset(x = (size.width / 2) - 320, y = size.height / 2),
                    end = Offset(x = (size.width / 2), y = size.height / 2),
                    strokeWidth = 10f
                )
            }
        }

//        min credit
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(
                    top = 60.dp
                )
        ) {
            Text(
                text = "300",
                color = Color.White,
                style = TextStyle(
                    fontSize = 25.sp
                )
            )
        }

//        max credit
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(top = 60.dp)
        ) {
            Text(
                text = "850",
                color = Color.White,
                style = TextStyle(
                    fontSize = 25.sp
                )
            )
        }
    }
}

@Composable
fun ComposeButtons(
    creditScoreViewModel: CreditScoreViewModel
) {
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
                creditScoreViewModel.calculateRotationPercentage(810)
            },

            ) {
            Text(text = "Animate")
        }

        Button(
            onClick = {
                creditScoreViewModel.calculateRotationPercentage(300)
            },
        ) {
            Text(text = "Reset")
        }
    }
}