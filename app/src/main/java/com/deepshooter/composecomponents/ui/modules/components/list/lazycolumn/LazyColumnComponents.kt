package com.deepshooter.composecomponents.ui.modules.components.list.lazycolumn

import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.utils.AppConstant.BASIC_SAMPLE
import com.deepshooter.composecomponents.utils.AppConstant.STICKY_HEADER_SAMPLE

data class LazyColumnComponents(
    val name: String,
    val route: ComponentsScreen
) {

    companion object {
        val layColumnComponentsList = listOf(
            LazyColumnComponents(
                name = BASIC_SAMPLE,
                route = ComponentsScreen.ComponentsListLazyColumnOne
            ),
            LazyColumnComponents(
                name = STICKY_HEADER_SAMPLE,
                route = ComponentsScreen.ComponentsListLazyColumnTwo
            )
        )
    }

}
