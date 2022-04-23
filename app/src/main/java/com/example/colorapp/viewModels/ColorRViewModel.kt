package com.example.colorapp.viewModels

import com.example.colorapp.colorRoom.ColorRepository

import androidx.lifecycle.*
import com.example.colorapp.colorRoom.ColorEntity
import kotlinx.coroutines.launch

class ColorRViewModel(private val repository: ColorRepository): ViewModel() {
    val allColors: LiveData<List<Int>> = repository.allColors.asLiveData()

    fun insert(color: ColorEntity) = viewModelScope.launch {
        repository.insert(color)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun deleteColor(color: ColorEntity) = viewModelScope.launch {
        repository.delete(color)
    }

    fun getAllColors(): List<Int>? {
        return allColors.value
    }


}

class ColorRViewModelFactory(private val repository: ColorRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ColorRViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ColorRViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}