package com.example.joshitutorials.presentation

sealed class Screen(val route: String){
    object HomeScreenRoute : Screen("home_screen")
    object TermOneScreenRoute: Screen("term_one_screen")
}
