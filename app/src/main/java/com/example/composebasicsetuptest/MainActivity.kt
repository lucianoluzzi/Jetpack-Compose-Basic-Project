package com.example.composebasicsetuptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasicsetuptest.ui.theme.ComposeBasicSetupTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
private fun App() {
    ComposeBasicSetupTestTheme {
        Scaffold(
            topBar = { TopBar() }
        ) { innerPadding ->
            Form(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text("Layouts codelab")
        }
    )
}

@Composable
private fun Form(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Email(Modifier.fillMaxWidth())
        Spacer(Modifier.width(8.dp))
        Password(Modifier.fillMaxWidth())
        Box(modifier = Modifier.fillMaxHeight()) {
            Button(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                onClick = { /*TODO*/ }
            ) {
                Text("Login")
            }
        }
    }
}

@Composable
private fun Email(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        modifier = modifier,
        value = email,
        onValueChange = {
            email = it
        },
        label = { Text("Email") }
    )
}

@Composable
private fun Password(modifier: Modifier = Modifier) {
    var password by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        modifier = modifier,
        value = password,
        onValueChange = {
            password = it
        },
        label = { Text("Password") }
    )
}

@Preview(showBackground = true)
@Composable
private fun FormPreview() {
    App()
}