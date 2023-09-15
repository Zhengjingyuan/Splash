package com.example.myapplication.ui.theme.navigation

sealed class Screen(val route:String){
    object Home:Screen("Home")

    object Splash:Screen("Splash")
}
