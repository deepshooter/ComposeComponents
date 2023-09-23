package com.deepshooter.composecomponents.ui.modules.components.list

import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.utils.AppConstant.GRID_WITH_LAZY_VERTICAL_GRID
import com.deepshooter.composecomponents.utils.AppConstant.LIST_WITH_COLUMN
import com.deepshooter.composecomponents.utils.AppConstant.LIST_WITH_LAZY_COLUMN
import com.deepshooter.composecomponents.utils.AppConstant.LIST_WITH_LAZY_ROW
import com.deepshooter.composecomponents.utils.AppConstant.LIST_WITH_ROW

data class ListComponents(
    val name: String,
    val route: ComponentsScreen
) {

    companion object {
        val listCompositionList = listOf(
            ListComponents(
                name = LIST_WITH_COLUMN,
                route = ComponentsScreen.ComponentsListColumn
            ),
            ListComponents(
                name = LIST_WITH_ROW,
                route = ComponentsScreen.ComponentsListRow
            ),
            ListComponents(
                name = LIST_WITH_LAZY_COLUMN,
                route = ComponentsScreen.ComponentsListLazyColumnIndex
            ),
            ListComponents(
                name = LIST_WITH_LAZY_ROW,
                route = ComponentsScreen.ComponentsListLazyRow
            ),
            ListComponents(
                name = GRID_WITH_LAZY_VERTICAL_GRID,
                route = ComponentsScreen.ComponentsListGridVertical
            )
        )
    }
}
