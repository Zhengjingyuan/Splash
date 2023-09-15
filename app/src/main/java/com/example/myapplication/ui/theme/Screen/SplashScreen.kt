package com.example.myapplication.ui.theme.Screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.Screen.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Screen.ui.theme.Purple40
import kotlinx.coroutines.delay

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Splash(1f)
                }
            }
        }
    }
}

@Composable
fun AnimatedSplashScreen( onNavigationToHome:()->Unit={}){
    var startAnimated by remember { mutableStateOf(false)}

    val alphaAni = animateFloatAsState(
        targetValue = if (startAnimated) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 =true){
        startAnimated=true
        delay(4000)
        onNavigationToHome.invoke()
    }
    Splash(alphaAni.value)

}

@Composable
fun Splash(alph:Float) {
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Purple40)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Icon(
            modifier=Modifier
                .size(120.dp)
                .alpha(alpha = alph),
            imageVector = Icons.Default.Email ,
            contentDescription = "Logo icon",
            tint = Color.White)


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        Splash(1f)
    }
}