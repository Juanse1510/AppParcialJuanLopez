package com.example.appparcialjuanlopez.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BmiDao {
    @Query("SELECT * FROM bmi_records ORDER BY date DESC")
    fun getAllRecords(): Flow<List<BmiRecord>>

    @Insert
    suspend fun insert(record: BmiRecord)

    @Delete
    suspend fun delete(record: BmiRecord)

    @Query("DELETE FROM bmi_records")
    suspend fun deleteAll()
} 