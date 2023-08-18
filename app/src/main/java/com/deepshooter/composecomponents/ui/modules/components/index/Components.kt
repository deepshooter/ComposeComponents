package com.deepshooter.composecomponents.ui.modules.components.index

import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.utils.AppConstant

data class Components(
    val name: String,
    val route: ComponentsScreen
) {
    companion object {
        val componentsList = listOf(
            Components(
                name = AppConstant.TEXT,
                route = ComponentsScreen.ComponentsText
            ),
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
