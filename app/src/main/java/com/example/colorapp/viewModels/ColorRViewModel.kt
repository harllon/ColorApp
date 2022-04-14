package com.example.colorapp.viewModels

import android.graphics.Color
import com.example.colorapp.ColorRoom.ColorRepository

import androidx.lifecycle.*
import com.example.colorapp.ColorRoom.ColorEntity
import kotlinx.coroutines.launch

class ColorRViewModel(private val repository: ColorRepository): ViewModel() {
    val allColors: LiveData<List<Int>> = repository.allColors.asLiveData()

    fun insert(color: ColorEntity) = viewModelScope.launch {
        repository.insert(color)
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