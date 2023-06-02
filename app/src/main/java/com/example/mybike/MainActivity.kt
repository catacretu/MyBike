package com.example.mybike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybike.ui.theme.MyBikeTheme
import com.example.mybike.views.HomeScreen
import com.example.mybike.views.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBikeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavigationGraph()
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SplashScreenPreview() {
//    MyBikeTheme {
//        Greeting("Android")
//    }
//}

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    )
    {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }

        composable("home_screen") {
            HomeScreen(navController = navController)
        }
    }
}