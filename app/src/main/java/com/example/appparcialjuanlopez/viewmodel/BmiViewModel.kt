package com.example.appparcialjuanlopez.viewmodel

import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.appparcialjuanlopez.data.BmiDatabase
import com.example.appparcialjuanlopez.data.BmiRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BmiViewModel(application: Application) : AndroidViewModel(application) {
    private val database = BmiDatabase.getDatabase(application)
    private val bmiDao = database.bmiDao()

    private val _backgroundColor = MutableStateFlow(Color.White)
    val backgroundColor: StateFlow<Color> = _backgroundColor.asStateFlow()

    val allRecords = bmiDao.getAllRecords()

    fun calculateBmi(weight: Float, height: Float): Pair<Float, String> {
        val bmi = weight / (height * height)
        val category = when {
            bmi < 18.5f -> "Bajo peso"
            bmi < 25f -> "Peso normal"
            bmi < 30f -> "Sobrepeso"
            else -> "Obesidad"
        }
        return Pair(bmi, category)
    }

    fun calculateAndSaveBmi(weight: Float, height: Float) {
        viewModelScope.launch {
            val (bmi, category) = calculateBmi(weight, height)
            val record = BmiRecord(
                weight = weight,
                height = height,
                bmi = bmi,
                category = category,
                date = System.currentTimeMillis()
            )
            withContext(Dispatchers.IO) {
                bmiDao.insert(record)
            }
        }
    }

    fun setBackgroundColor(color: Color) {
        _backgroundColor.value = color
    }
} 