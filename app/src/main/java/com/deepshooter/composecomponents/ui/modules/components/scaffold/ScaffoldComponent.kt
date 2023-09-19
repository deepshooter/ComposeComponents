package com.deepshooter.composecomponents.ui.modules.components.scaffold

import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.utils.AppConstant.SCAFFOLD_WITH_BOTTOM_BAR_AND_CUTOUT
import com.deepshooter.composecomponents.utils.AppConstant.SCAFFOLD_WITH_COROUTINES_SNACKBAR
import com.deepshooter.composecomponents.utils.AppConstant.SCAFFOLD_WITH_CUSTOM_SNACKBAR
import com.deepshooter.composecomponents.utils.AppConstant.SCAFFOLD_WITH_SIMPLE_SNACKBAR
import com.deepshooter.composecomponents.utils.AppConstant.SIMPLE_SCAFFOLD_WITH_TOP_BAR

data class ScaffoldComponent(
    val name: String,
    val route: ComponentsScreen
) {
    companion object {
        val scaffoldCompositionList = listOf(
            ScaffoldComponent(
                name = SIMPLE_SCAFFOLD_WITH_TOP_BAR,
                route = ComponentsScreen.ComponentsScaffoldOne
            ),
            ScaffoldComponent(
                name = SCAFFOLD_WITH_BOTTOM_BAR_AND_CUTOUT,
                route = ComponentsScreen.ComponentsScaffoldTwo
            ),
            ScaffoldComponent(
                name = SCAFFOLD_WITH_SIMPLE_SNACKBAR,
                route = ComponentsScreen.ComponentsScaffoldThree
            ),
            ScaffoldComponent(
                name = SCAFFOLD_WITH_CUSTOM_SNACKBAR,
                route = ComponentsScreen.ComponentsScaffoldFour
            ),
            ScaffoldComponent(
                name = SCAFFOLD_WITH_COROUTINES_SNACKBAR,
                route = ComponentsScreen.ComponentsScaffoldFive
            )
        )
    }
}
