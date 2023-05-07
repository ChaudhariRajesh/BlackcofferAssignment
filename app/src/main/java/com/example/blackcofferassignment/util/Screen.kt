package com.example.blackcofferassignment.util

sealed class Screen(val route : String) {
    object MainScreen : Screen("main_screen")
    object RefineScreen : Screen("refine_screen")
    object ExploreScreen : Screen("explore_screen")
    object NetworkScreen : Screen("network_screen")
}