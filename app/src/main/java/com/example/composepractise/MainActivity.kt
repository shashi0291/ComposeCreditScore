package com.example.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.composepractise.ui.theme.ComposePractiseTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalUnitApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(
                        color = Color.Green,
                        shape = RectangleShape
                    )
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.padding(50.dp)
                        .background(
                            color = Color.Cyan,
                            shape = RectangleShape
                        ),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Row 1",
                        color = Color.Blue,
                        modifier = Modifier.padding(20.dp),
                        fontSize = TextUnit(20.0f, TextUnitType.Sp)
                    )
                    Text(
                        text = "Row 2",
                        color = Color.Blue,
                        modifier = Modifier.padding(20.dp),
                        fontSize = TextUnit(30.0f, TextUnitType.Sp)
                    )
                }

                Column(
                    Modifier.padding(top = 10.dp),
                    Arrangement.spacedBy(10.dp)
                ) {
                    Text(text = "Column1", color = Color.Red)
                    Text(text = "Column2", color = Color.Red)
                }
            }
        }
    }
}
