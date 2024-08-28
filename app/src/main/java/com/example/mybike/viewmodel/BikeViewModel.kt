package com.example.mybike.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybike.data.local.model.BikeEntity
import com.example.mybike.data.repository.BikeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BikeViewModel @Inject constructor(
    private val repository: BikeRepository
) : ViewModel() {

    private val _bikeData = MutableLiveData<List<BikeEntity>>(emptyList())
    val bikeData: LiveData<List<BikeEntity>>
        get() = _bikeData

    init {
        fetchBikeData()
    }

    fun saveBike(bikeEntity: BikeEntity) {
        viewModelScope.launch {
            repository.saveBike(bikeEntity)
        }

    }
    fun fetchBikeData() {
        viewModelScope.launch {
            _bikeData.value = repository.getBikes()
        }
    }
    fun getBikeById(bikeId: Int): BikeEntity {
        return repository.getBikeById(bikeId)
    }

    fun updateBike(bikeEntity: BikeEntity) {
        repository.updateBike(bikeEntity)
    }

    fun deleteBike(bikeEntity: BikeEntity) {
        viewModelScope.launch {
            repository.deleteBike(bikeEntity)
        }
    }

}