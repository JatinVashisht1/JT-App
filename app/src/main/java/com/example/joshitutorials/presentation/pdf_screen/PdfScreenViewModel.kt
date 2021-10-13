package com.example.joshitutorials.presentation.pdf_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PdfScreenViewModel @Inject constructor(): ViewModel() {
    private val _chapterState = mutableStateOf<String>("")
    val chapterState: State<String> = _chapterState
    fun defineChapter(chapter: String){
        _chapterState.value = chapter
    }
}