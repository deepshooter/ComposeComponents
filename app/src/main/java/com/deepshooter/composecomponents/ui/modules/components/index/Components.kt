package com.deepshooter.composecomponents.ui.modules.components.index

import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.utils.AppConstant.BADGE
import com.deepshooter.composecomponents.utils.AppConstant.NAVIGATION_BAR
import com.deepshooter.composecomponents.utils.AppConstant.TEXT
import com.deepshooter.composecomponents.utils.AppConstant.TOP_APP_BAR

data class Components(
    val name: String,
    val route: ComponentsScreen
) {
    companion object {
        val componentsList = listOf(
            Components(
                name = TEXT,
                route = ComponentsScreen.ComponentsText
            ),
            Components(
                name = TOP_APP_BAR,
                route = ComponentsScreen.ComponentsTopAppBar
            ),
            Components(
                name = NAVIGATION_BAR,
                route = ComponentsScreen.ComponentsNavigationBar
            ),
            Components(
                name = BADGE,
                route = ComponentsScreen.ComponentsBadge
            )
        )
    }
}
