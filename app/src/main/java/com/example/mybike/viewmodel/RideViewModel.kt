package com.example.mybike.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybike.data.local.model.RideEntity
import com.example.mybike.data.repository.RideRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class RideViewModel @Inject constructor(
    private val repository: RideRepository
) : ViewModel() {
    val rideData: MutableState<List<RideEntity>> = mutableStateOf(emptyList())


    init {
        viewModelScope.launch {
            val data = fetchRideData()
            rideData.value = data
        }
    }

    private fun fetchRideData(): List<RideEntity> {
        return repository.getRides()
    }
}
