package com.example.joshitutorials.presentation.home_screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.joshitutorials.presentation.Screen

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
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .fillMaxHeight(0.25f)
//            .align(Alignment.CenterHorizontally)
//            .wrapContentHeight()
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
    Card(
        modifier = modifier
            .clickable { navController.navigate(route = Screen.ChapterListScreenRoute.route)},
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Chapters\nTerm 1 and Term 2",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp),
                color = MaterialTheme.colors.primaryVariant
            )
        }
    }
}