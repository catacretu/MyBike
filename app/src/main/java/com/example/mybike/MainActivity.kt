package com.example.mybike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mybike.components.NavigationGraph
import com.example.mybike.ui.theme.MyBikeTheme
import com.example.mybike.viewmodel.BikeViewModel
import com.example.mybike.viewmodel.RideViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val rideViewModel: RideViewModel by viewModels()
    private val bikeViewModel: BikeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBikeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavigationGraph(rideViewModel,bikeViewModel)
                }
            }
        }
    }
}

