package com.example.joshitutorials.presentation.home_screen

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.joshitutorials.presentation.home_screen.components.TermOneChapters

@Composable
fun HomeScreen(context: Context, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.secondary),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Joshi Tutorials",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(8.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primaryVariant
            )
            Text(
                text = "Mobile no. 9646034012",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(8.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primaryVariant
            )
        }
        Term1(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
            context = context,
            navController = navController
        )

    }
}

@Composable
fun Term1(
    modifier: Modifier = Modifier,
    context: Context,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var cardState by rememberSaveable { mutableStateOf(false) }
    val termOneList = viewModel.chapterState.value
    Card(
        modifier = modifier
            .animateContentSize(tween(300, 200, FastOutLinearInEasing))
            .clickable { cardState = !cardState }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = MaterialTheme.colors.primary),
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Term 1 and Term 2",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colors.primaryVariant
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Open",
                    tint = MaterialTheme.colors.primaryVariant,

                    modifier = Modifier
                        .size(40.dp)
                        .rotate(if (cardState) 180f else 0f)
                )
            }
            if(cardState){
                TermOneChapters(term_one_chapters_name = termOneList, context = context, navController = navController)
            }
        }
    }
}