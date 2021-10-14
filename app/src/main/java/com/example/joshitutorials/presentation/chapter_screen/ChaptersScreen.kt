package com.example.joshitutorials.presentation.chapter_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.joshitutorials.presentation.MainActivity
import com.example.joshitutorials.presentation.home_screen.HomeScreenViewModel

@Composable
fun ChaptersScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    mainActivity: MainActivity,
    navController: NavHostController
) {
    TermOneChapters(
        term_one_chapters_name = viewModel.chapterState.value,
        context = mainActivity,
        navController = navController
    )
}