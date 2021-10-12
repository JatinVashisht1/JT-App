package com.example.joshitutorials.presentation.home_screen.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TermOneChapters(term_one_chapters_name: List<String>, context: Context){

    LazyColumn(){
        items(term_one_chapters_name){item->
            TermOneChapter(item = item, context = context)
        }
    }

}

@Composable
fun TermOneChapter(item: String, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast.makeText(context, item, Toast.LENGTH_LONG).show()
            }
            .background(MaterialTheme.colors.secondary)
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        Text(text = item,
            modifier = Modifier
            .fillMaxWidth()
                .padding(8.dp),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
    }
}