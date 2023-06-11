package com.example.mybike.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybike.data.local.model.RideEntity
import com.example.mybike.data.repository.RideRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RideViewModel @Inject constructor(
    private val repository: RideRepository
) : ViewModel() {

    private val _rideData = fetchRideData().toMutableStateList()
    val rideData: List<RideEntity>
        get() = _rideData
//    val rideData: MutableState<List<RideEntity>> = mutableStateOf(emptyList())
//    init {
//        viewModelScope.launch {
//            val data = fetchRideData()
//            rideData.value = data
//        }
//    }

    fun saveRide(rideEntity: RideEntity){
        repository.saveRide(rideEntity)
    }
    private fun fetchRideData(): List<RideEntity> {
        return repository.getRides()
    }
    fun getRideById(rideId: Int): RideEntity{
        return repository.getRideById(rideId)
    }

    fun updateRide(rideEntity: RideEntity){
        repository.updateRide(rideEntity)
    }
    fun deleteRide(rideEntity: RideEntity) {
        repository.deleteRide(rideEntity)
    }
}
