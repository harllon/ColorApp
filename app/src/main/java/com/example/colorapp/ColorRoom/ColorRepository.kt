package com.example.colorapp.ColorRoom

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ColorRepository(private val colorDao: ColorDao) {

    val allColors: Flow<List<Int>> = colorDao.getAllColors()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(color: ColorEntity){
        colorDao.insert(color)
    }

    suspend fun deleteAll(){
        colorDao.deleteAll()
    }
}