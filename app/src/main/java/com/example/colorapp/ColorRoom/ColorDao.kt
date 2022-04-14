package com.example.colorapp.ColorRoom

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {
    @Query("DELETE FROM color_table")
    suspend fun deleteAll()

    /*@Delete
    fun deleteColor(color: Color)*/

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(color: ColorEntity)

    @Query("SELECT * FROM color_table")
    fun getAllColors(): Flow<List<Int>>

}