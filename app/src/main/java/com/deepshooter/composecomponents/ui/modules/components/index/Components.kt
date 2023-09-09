package com.deepshooter.composecomponents.ui.modules.components.index

import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.utils.AppConstant.BADGE
import com.deepshooter.composecomponents.utils.AppConstant.BUTTON
import com.deepshooter.composecomponents.utils.AppConstant.CARD
import com.deepshooter.composecomponents.utils.AppConstant.FLOATING_ACTION_BUTTON
import com.deepshooter.composecomponents.utils.AppConstant.NAVIGATION_BAR
import com.deepshooter.composecomponents.utils.AppConstant.TEXT
import com.deepshooter.composecomponents.utils.AppConstant.TEXT_FIELD
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
                name = TEXT_FIELD,
                route = ComponentsScreen.ComponentsTextField
            ),
            Components(
                name = BUTTON,
                route = ComponentsScreen.ComponentsButton
            ),
            Components(
                name = FLOATING_ACTION_BUTTON,
                route = ComponentsScreen.ComponentsFloatingActionButton
            ),
            Components(
                name = CARD,
                route = ComponentsScreen.ComponentsCard
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
