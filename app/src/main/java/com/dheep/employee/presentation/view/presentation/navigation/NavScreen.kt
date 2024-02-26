package com.dheep.employee.presentation.navigation

sealed class NavScreen(val route: String) {
    object HomeScreen : NavScreen(NavRoutes.homeScreen)

    object DetailsScreen : NavScreen(NavRoutes.detailsScreen)

}
