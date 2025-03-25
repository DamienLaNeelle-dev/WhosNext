package com.example.whosnext

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            NavHost(navController = navController, startDestination = "HomeScreen"){
                composable("HomeScreen") { navController }
                composable("login") { MainActivity() }
            }
            LoginButton(navController = navController)
            TopAppBar(
                title = { Text("Home Screen") }
            )
        },
        content = {innerPadding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ){
                Text(text = "Hello from HomeScreen!")
            }
        }
    )
}

@Composable
fun LoginButton(navController: NavController){
    Button(
        onClick = {navController.navigate("login")}
    ){
        Text(text = "X")
    }
}


