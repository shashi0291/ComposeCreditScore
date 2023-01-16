package com.example.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CreditScoreActivity : ComponentActivity() {

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
                CreditScoreBar()
            }
        }
    }
}

@Composable
fun CreditScoreBar() {
    Box(
        modifier = Modifier
            .width(380.dp)
            .height(380.dp)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
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

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(color = Color.Cyan)
        ) {
            Canvas(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            ) {
                drawArc(
                    color = Color.Gray,
                    startAngle = 0f,
                    sweepAngle = -180f,
                    useCenter = true,
                    size = Size(width = 50f, height = 50f)
                )

                drawLine(
                    color = Color.Gray,
                    start = Offset(x = (size.width / 2) - 320, y = size.height / 2),
                    end = Offset(x = (size.width / 2), y = size.height / 2),
                    strokeWidth = 10f,
//                    rotate(
//                        degrees = 50f,
//                        pivot = Offset(size.width / 2, size.height/ 2),
//                        block = anima
//                    )
                )


            }
        }

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

//        Box(
//            modifier = Modifier
//                .align(Alignment.Center)
//        ) {
//            Text(
//                text = "810",
//                color = Color.White,
//                style = TextStyle(
//                    fontSize = 50.sp
//                )
//            )
//        }
    }
}


