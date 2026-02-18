package com.example.jogododado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jogododado.ui.theme.JogoDoDadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoDoDadoTheme {
                JogoDoDado(modifier = Modifier.fillMaxSize());

            }
        }
    }
}

@Composable
fun JogoDoDado(modifier: Modifier = Modifier) {
    var soma by remember { mutableStateOf(0)}
    var total by remember { mutableStateOf(0)}
    var result1 by remember { mutableStateOf(1)}
    var result2 by remember { mutableStateOf(1)}
    var imageResult1 = when(result1){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_6
    }
    var imageResult2 = when(result2){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Surface(
            color = Color(0xFF2B2D42),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .width(64.dp)
                .height(45.dp)
                .safeDrawingPadding()

        ) {
            Box(contentAlignment = Alignment.Center){
                Text(
                    text = "  $soma",
                    fontSize = 30.sp,
                    color = Color.White )
            }

        }

        Row {
            Image(painter = painterResource(imageResult1), contentDescription = "dado");
            Image(painter = painterResource(imageResult2), contentDescription = "dado");
            Spacer(modifier = Modifier.height(20.dp))


        }

        Button(onClick = {
            result1 = (1..6).random()
            result2 = (1..6).random()
            soma = result1 + result2
            total += soma
        }) {
            Text(text = stringResource(id = R.string.rolar))
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Surface(
                color = Color(0xFF2B2D42),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .width(70.dp)
                    .height(45.dp)
                    .safeDrawingPadding()

            ) {
                Box(contentAlignment = Alignment.Center){
                    Text(
                        text = "  $total",
                        fontSize = 30.sp,
                        color = Color.White )
                }

            }
            Spacer(modifier = Modifier.width(130.dp))
            Button(onClick = {
                result1 = (1)
                result2 = (1)
                soma = 0
                total = 0
            }) {
                Text(text = stringResource(id = R.string.Reset))
            }
        }

    }
}