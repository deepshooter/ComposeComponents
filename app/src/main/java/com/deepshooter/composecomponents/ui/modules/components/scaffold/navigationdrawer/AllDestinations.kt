package com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer

import androidx.navigation.NavHostController
import com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer.AllDestinations.HOME
import com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer.AllDestinations.SETTINGS

object AllDestinations {
    const val HOME = "Home"
    const val SETTINGS = "Settings"
}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToHome() {
        navController.navigate(HOME) {
            popUpTo(HOME)
        }
    }

    fun navigateToSettings() {
        navController.navigate(SETTINGS) {
            launchSingleTop = true
            restoreState = true
        }
    }
}
