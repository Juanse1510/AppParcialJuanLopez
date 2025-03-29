package com.example.appparcialjuanlopez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appparcialjuanlopez.ui.theme.AppParcialJuanLopezTheme
import com.example.appparcialjuanlopez.viewmodel.BmiViewModel
import com.example.appparcialjuanlopez.ui.HomeScreen
import com.example.appparcialjuanlopez.ui.DetailsScreen
import com.example.appparcialjuanlopez.ui.SettingsScreen
import com.example.appparcialjuanlopez.ui.InputScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppParcialJuanLopezTheme {
                val viewModel: BmiViewModel = viewModel()
                val backgroundColor by viewModel.backgroundColor.collectAsState(initial = Color.White)
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = backgroundColor
                ) {
                    NavHost(navController = navController, startDestination = "input") {
                        composable("input") {
                            InputScreen(
                                onNavigateToDetails = { navController.navigate("details") }
                            )
                        }
                        composable("home") {
                            HomeScreen(
                                onNavigateToDetails = { navController.navigate("details") },
                                onNavigateToSettings = { navController.navigate("settings") }
                            )
                        }
                        composable("details") {
                            DetailsScreen(
                                onNavigateToSettings = { navController.navigate("settings") }
                            )
                        }
                        composable("settings") {
                            SettingsScreen(
                                onNavigateBack = { navController.navigateUp() }
                            )
                        }
                    }
                }
            }
        }
    }
}