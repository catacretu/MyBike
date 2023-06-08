package com.example.mybike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mybike.components.NavigationGraph
import com.example.mybike.ui.theme.MyBikeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

