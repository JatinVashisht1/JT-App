package com.example.joshitutorials.presentation.home_screen

import android.app.Application
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(

) : ViewModel() {
    private val _chapterState = mutableStateOf(listOf<String>(
            "Chapter 1: Sets",
            "Chapter 2: Relations and Functions",
            "Chapter 3: Trigonometric Functions",
            "Chapter 4: Principle of Mathematical Induction",
            "Chapter 5: Complex Numbers and Quadratic Equations",
            "Chapter 6: Linear Inequalities",
            "Chapter 7: Permutations and Combinations",
            "Chapter 8: Binomial Theorem"
    ))
    val chapterState: State<List<String>> = _chapterState

}