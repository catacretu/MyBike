package com.example.mybike.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _rideData = MutableLiveData<List<RideEntity>>(emptyList())
    val rideData: LiveData<List<RideEntity>>
        get() = _rideData

    init {
        fetchRideData()
    }

    fun saveRide(rideEntity: RideEntity) {
        viewModelScope.launch {
            repository.saveRide(rideEntity)
        }

    }
    fun fetchRideData() {
        viewModelScope.launch {
            _rideData.value = repository.getRides()
        }
    }
    fun getRideById(rideId: Int): RideEntity{
        return repository.getRideById(rideId)
    }

    fun updateRide(rideEntity: RideEntity){
        repository.updateRide(rideEntity)
    }
    fun deleteRide(rideEntity: RideEntity) {
        viewModelScope.launch {
            repository.deleteRide(rideEntity)
        }

    }
}
