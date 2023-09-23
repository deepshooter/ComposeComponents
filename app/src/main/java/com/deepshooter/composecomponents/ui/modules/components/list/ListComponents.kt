package com.deepshooter.composecomponents.ui.modules.components.list

import com.deepshooter.composecomponents.ui.ComponentsScreen

data class ListComponents(
    val name: String,
    val route: ComponentsScreen
) {

    companion object {
        val listCompositionList = listOf(
            ListComponents(
                name = "List with Column",
                route = ComponentsScreen.ComponentsListColumn
            )
        )
    }

}
