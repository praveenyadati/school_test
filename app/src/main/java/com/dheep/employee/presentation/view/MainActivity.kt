package com.dheep.employee.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.dheep.employee.core.designsystem.theme.SchoolAppTheme
import com.dheep.employee.presentation.view.presentation.navigation.NavGraph
import com.dheep.employee.presentation.view.presentation.view.SchoolsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SchoolsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SchoolAppTheme {
                NavGraph(viewModel = viewModel)
            }
        }
    }
}
