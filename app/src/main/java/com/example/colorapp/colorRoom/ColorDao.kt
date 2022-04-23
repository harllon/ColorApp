package com.example.colorapp.colorRoom

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {
    @Query("DELETE FROM color_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteColor(color: ColorEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(color: ColorEntity)

    @Query("SELECT * FROM color_table")
    fun getAllColors(): Flow<List<Int>>

}