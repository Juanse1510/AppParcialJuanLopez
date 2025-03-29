package com.example.appparcialjuanlopez.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bmi_records")
data class BmiRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val weight: Float,
    val height: Float,
    val bmi: Float,
    val category: String,
    val date: Long
) 