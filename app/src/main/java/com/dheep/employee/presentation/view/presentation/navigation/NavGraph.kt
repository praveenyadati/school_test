package com.dheep.employee.presentation.view.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dheep.employee.presentation.navigation.NavScreen
import com.dheep.employee.presentation.view.presentation.view.HomeScreen
import com.dheep.employee.presentation.view.presentation.view.SchoolsViewModel

@Composable
fun NavGraph(
    startDestination: String = NavScreen.HomeScreen.route,
    viewModel: SchoolsViewModel
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = startDestination
        ) {
            composable(NavScreen.HomeScreen.route) {
                HomeScreen(viewModel, navController)
            }
        }
    }
}