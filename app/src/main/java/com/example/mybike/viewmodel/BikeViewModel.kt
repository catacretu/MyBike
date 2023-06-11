package com.example.mybike.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.mybike.data.local.model.BikeEntity
import com.example.mybike.data.repository.BikeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BikeViewModel @Inject constructor(
    private val repository: BikeRepository
): ViewModel() {

    private val _bikeData = fetchBikeData().toMutableStateList()

    val bikeData: List<BikeEntity>
        get() = _bikeData

    fun saveBike(bikeEntity: BikeEntity){
        repository.saveBike(bikeEntity)
    }

    private fun fetchBikeData(): List<BikeEntity> {
        return repository.getBikes()
    }

    fun updateBikeData(bikeEntity: BikeEntity) {
        repository.updateBike(bikeEntity)
    }

    fun deleteBike(bikeEntity: BikeEntity){
        repository.deleteBike(bikeEntity)
    }

}