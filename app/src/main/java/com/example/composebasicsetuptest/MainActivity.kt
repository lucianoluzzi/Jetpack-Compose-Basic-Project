package com.example.composebasicsetuptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composebasicsetuptest.ui.screens.NavigationDestination
import com.example.composebasicsetuptest.ui.screens.dashboard.DashboardScreen
import com.example.composebasicsetuptest.ui.theme.ComposeBasicSetupTestTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun App() {
    ComposeBasicSetupTestTheme {
        Navigation()
    }
}

@ExperimentalFoundationApi
@Composable
private fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationDestination.LoginForm.route
    ) {
        composable(route = NavigationDestination.LoginForm.route) {
            DashboardScreen()
        }
    }
}