package com.example.colorapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel: ViewModel() {
    var color = MutableLiveData<Int>()

    fun setColor(colorValue : Int){
        color.value = colorValue
    }
    fun getColor() : Int?{
        return color.value
    }
}