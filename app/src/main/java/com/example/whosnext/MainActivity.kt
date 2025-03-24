package com.example.whosnext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whosnext.ui.theme.WhosNextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhosNextTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        NavHost(navController = navController, startDestination = "login"){
                            composable("login") {Layout(navController)}
                            composable("HomeScreen") {HomeScreen()}
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Layout(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 25.dp)
    ) {
        Greeting(name = "Who's Next?");
        HomeScreenButton(navController = navController)
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name, C'est à qui le tour?",
        modifier = modifier
            .background(color = Color.Red),
        color = Color.White
    )
}

@Composable
fun HomeScreenButton(navController: NavController, modifier: Modifier = Modifier){
    Button(
        onClick = { navController.navigate("HomeScreen") },
        modifier = modifier
            .padding(50.dp)
    ){
        Text(text = "Home screen")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhosNextTheme {
        Greeting("Android")
    }
}