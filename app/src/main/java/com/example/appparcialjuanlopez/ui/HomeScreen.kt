package com.example.appparcialjuanlopez.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appparcialjuanlopez.viewmodel.BmiViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import androidx.compose.runtime.rememberCoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetails: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var showSuccess by remember { mutableStateOf(false) }
    val viewModel: BmiViewModel = viewModel()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de IMC",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        OutlinedTextField(
            value = weight,
            onValueChange = { 
                weight = it
                showError = false
                showSuccess = false
            },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth(),
            isError = showError && weight.isEmpty()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = height,
            onValueChange = { 
                height = it
                showError = false
                showSuccess = false
            },
            label = { Text("Altura (m) - Ejemplo: 1.75") },
            modifier = Modifier.fillMaxWidth(),
            isError = showError && height.isEmpty(),
            supportingText = {
                Text("Ingrese su altura en metros. Ejemplo: 1.75 para 175 cm")
            }
        )
        
        if (showError) {
            Text(
                text = "Por favor, complete todos los campos",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        
        if (showSuccess) {
            Text(
                text = "¡Registro guardado exitosamente!",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = {
                if (weight.isNotEmpty() && height.isNotEmpty()) {
                    try {
                        val weightValue = weight.toFloat()
                        val heightValue = height.toFloat()
                        if (heightValue <= 0 || weightValue <= 0) {
                            showError = true
                            return@Button
                        }
                        viewModel.calculateAndSaveBmi(weightValue, heightValue)
                        showSuccess = true
                        weight = ""
                        height = ""
                        // Navegar después de un breve delay para que el usuario vea el mensaje de éxito
                        scope.launch {
                            delay(1500)
                            onNavigateToDetails()
                        }
                    } catch (e: NumberFormatException) {
                        showError = true
                    }
                } else {
                    showError = true
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
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = onNavigateToSettings,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Configuración")
        }
    }
} 