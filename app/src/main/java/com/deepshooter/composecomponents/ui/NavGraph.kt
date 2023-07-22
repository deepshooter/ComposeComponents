package com.deepshooter.composecomponents.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Animations : Screen("animation")
    object Compositions : Screen("composition")
    object UIs : Screen("ui")
    object Tutorials : Screen("tutorial")
}