package com.example.appparcialjuanlopez.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details")
    object Settings : Screen("settings")
}

object NavGraph {
    val route = "nav_graph"
} 