package com.example.joshitutorials.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.joshitutorials.presentation.home_screen.HomeScreen
import com.example.joshitutorials.presentation.ui.theme.JoshiTutorialsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JoshiTutorialsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Black) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreenRoute.route,
                    ){
                        composable(Screen.HomeScreenRoute.route){
                            HomeScreen(context = this@MainActivity, navController = navController)
                        }
                        composable(Screen.TermOneScreenRoute.route+"?chapterName={chapterName}",
                        arguments = listOf(navArgument("chapterName"){defaultValue = "NOT_DEFINED"})
                            ){
                                TermOneScreen(
                                    navController = navController,
                                    chapterName = it.arguments?.getString("chapterName"),
                                    this@MainActivity
                                )
                        }
                    }
                }
            }
        }
    }
}