package com.example.composebasicsetuptest.ui.screens

sealed class NavigationDestination(val route: String, val arguments: String? = null) {
    object LoginForm : NavigationDestination("loginForm")

    fun route() = "$route$arguments"
}
