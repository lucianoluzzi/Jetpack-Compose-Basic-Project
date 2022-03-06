package com.example.composebasicsetuptest.ui.screens.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composebasicsetuptest.domain.model.Muscle
import com.example.composebasicsetuptest.ui.theme.ComposeBasicSetupTestTheme

@ExperimentalFoundationApi
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold { innerPadding ->
        Dashboard(modifier = modifier.padding(innerPadding))
    }
}

@ExperimentalFoundationApi
@Composable
private fun Dashboard(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val muscles = viewModel.muscles.collectAsState().value
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        MuscleDashboard(
            muscles = muscles
        )
    }
}

@ExperimentalFoundationApi
@Composable
private fun MuscleDashboard(muscles: List<Muscle>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(muscles) { muscle ->
            GridTile(
                muscle = muscle,
                onClick = { }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun GridTile(
    muscle: Muscle,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 4.dp,
        onClick = {
            onClick()
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(muscle.iconResource),
                contentDescription = muscle.name
            )
            Spacer(Modifier.size(8.dp))
            Text(
                text = muscle.name
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
private fun FormPreview() {
    ComposeBasicSetupTestTheme {
        DashboardScreen()
    }
}