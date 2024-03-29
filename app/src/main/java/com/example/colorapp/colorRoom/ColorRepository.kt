package com.example.colorapp.colorRoom

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

    suspend fun delete(color: ColorEntity){
        colorDao.deleteColor(color)
    }
}