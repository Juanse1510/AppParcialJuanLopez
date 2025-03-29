package com.example.appparcialjuanlopez.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appparcialjuanlopez.viewmodel.BmiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit
) {
    val viewModel: BmiViewModel = viewModel()
    val backgroundColor by viewModel.backgroundColor.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Configuración") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Text("←")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Color de fondo",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ColorOption(
                    color = Color.White,
                    isSelected = backgroundColor == Color.White,
                    onClick = { viewModel.setBackgroundColor(Color.White) }
                )
                ColorOption(
                    color = Color.LightGray,
                    isSelected = backgroundColor == Color.LightGray,
                    onClick = { viewModel.setBackgroundColor(Color.LightGray) }
                )
                ColorOption(
                    color = Color(0xFFE3F2FD),
                    isSelected = backgroundColor == Color(0xFFE3F2FD),
                    onClick = { viewModel.setBackgroundColor(Color(0xFFE3F2FD)) }
                )
            }
        }
    }
}

@Composable
fun ColorOption(
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(color)
            .padding(4.dp)
            .background(
                if (isSelected) MaterialTheme.colorScheme.primary
                else Color.Transparent
            ),
        contentAlignment = Alignment.Center
    ) {
        if (isSelected) {
            Text("✓", color = Color.White)
        }
    }
} 