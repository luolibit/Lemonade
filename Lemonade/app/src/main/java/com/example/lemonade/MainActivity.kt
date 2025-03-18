package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun LemonadeApp(){
    LemonadeButtonAndImage()
}

@Composable
fun LemonadeButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //altura
            .background(Color(0xFFFFEB3B))
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = stringResource(R.string.app_name),
            fontSize = 18.sp
        )
    }

    var click by remember { mutableStateOf(1) }
    val imageResource= when(click){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textDisplay = when(click){
        1 -> stringResource(R.string.image1)
        2 -> stringResource(R.string.image2)
        3 -> stringResource(R.string.image3)
        else -> stringResource(R.string.image4)
    }
    val textDescription = when(click){
        1 -> stringResource(R.string.descImage1)
        2 -> stringResource(R.string.descImage2)
        3 -> stringResource(R.string.descImage3)
        else -> stringResource(R.string.descImage4)
    }

    fun nextImage(){
        if (click >= 4) {
            click = 1
        } else {
            click++
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick =  { nextImage() }) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = textDescription
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = textDisplay,
            fontSize = 18.sp
        )
    }
}

