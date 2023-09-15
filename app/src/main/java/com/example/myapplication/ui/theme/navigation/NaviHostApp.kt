package com.example.myapplication.ui.theme.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.Screen.AnimatedSplashScreen
import com.example.myapplication.ui.theme.Screen.HomeContent
import com.example.myapplication.ui.theme.Screen.Splash
import com.example.myapplication.ui.theme.Screen.SplashScreen
import com.example.myapplication.ui.theme.navigation.ui.theme.MyApplicationTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class NaviHostApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NaviHostContent(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            AnimatedSplashScreen(onNavigationToHome = {
                navigationController.navigate(Screen.Home.route)
            })
        }
        composable(Screen.Home.route) {
            HomeContent()
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview13() {
        MyApplicationTheme {

        }
    }
}

