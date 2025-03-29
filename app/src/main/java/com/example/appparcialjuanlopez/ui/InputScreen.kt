package com.example.appparcialjuanlopez.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appparcialjuanlopez.viewmodel.BmiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(
    onNavigateToDetails: () -> Unit
) {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    val viewModel: BmiViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Ingrese sus datos",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Altura (m)") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = {
                val weightValue = weight.toFloatOrNull()
                val heightValue = height.toFloatOrNull()
                if (weightValue != null && heightValue != null) {
                    viewModel.calculateAndSaveBmi(weightValue, heightValue)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular IMC")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = onNavigateToDetails,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Historial")
        }
    }
} 