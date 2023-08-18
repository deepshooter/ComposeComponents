package com.deepshooter.composecomponents.ui.modules.components.index

import com.deepshooter.composecomponents.ui.ComponentsScreen

data class Components(
    val name: String,
    val route: ComponentsScreen
) {
    companion object {
        val componentsList = listOf(
            Components(
                name = "TopAppBar",
                route = ComponentsScreen.ComponentsTopAppBar
            ),
            Components(
                name = "NavigationBar",
                route = ComponentsScreen.ComponentsNavigationBar
            ),
            Components(
                name = "Badge",
                route = ComponentsScreen.ComponentsBadge
            )
        )
    }
}
