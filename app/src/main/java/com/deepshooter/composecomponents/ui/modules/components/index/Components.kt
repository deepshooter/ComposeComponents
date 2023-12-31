package com.deepshooter.composecomponents.ui.modules.components.index

import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.utils.AppConstant.BADGE
import com.deepshooter.composecomponents.utils.AppConstant.BUTTON
import com.deepshooter.composecomponents.utils.AppConstant.CARD
import com.deepshooter.composecomponents.utils.AppConstant.CHECKBOX
import com.deepshooter.composecomponents.utils.AppConstant.DIALOG
import com.deepshooter.composecomponents.utils.AppConstant.DROPDOWN_MENU
import com.deepshooter.composecomponents.utils.AppConstant.FLOATING_ACTION_BUTTON
import com.deepshooter.composecomponents.utils.AppConstant.LIST
import com.deepshooter.composecomponents.utils.AppConstant.LIST_ITEM
import com.deepshooter.composecomponents.utils.AppConstant.NAVIGATION_BAR
import com.deepshooter.composecomponents.utils.AppConstant.PROGRESS_INDICATOR
import com.deepshooter.composecomponents.utils.AppConstant.SCAFFOLD
import com.deepshooter.composecomponents.utils.AppConstant.SLIDER
import com.deepshooter.composecomponents.utils.AppConstant.SNACKBAR
import com.deepshooter.composecomponents.utils.AppConstant.PULL_REFRESH
import com.deepshooter.composecomponents.utils.AppConstant.RADIO_BUTTON
import com.deepshooter.composecomponents.utils.AppConstant.SWIPE_TO_DISMISS
import com.deepshooter.composecomponents.utils.AppConstant.SWITCH
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
                name = CHECKBOX,
                route = ComponentsScreen.ComponentsCheckBox
            ),
            Components(
                name = DIALOG,
                route = ComponentsScreen.ComponentsDialog
            ),
            Components(
                name = DROPDOWN_MENU,
                route = ComponentsScreen.ComponentsDropDownMenu
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
            ),
            Components(
                name = SLIDER,
                route = ComponentsScreen.ComponentsSlider
            )
            ,
            Components(
                name = PROGRESS_INDICATOR,
                route = ComponentsScreen.ComponentsProgressIndicator
            ),
            Components(
                name = SNACKBAR,
                route = ComponentsScreen.ComponentsSnackBar
            ),
            Components(
                name = SCAFFOLD,
                route = ComponentsScreen.ComponentsScaffoldIndex
            ),
            Components(
                name = LIST,
                route = ComponentsScreen.ComponentsListIndex
            ),
            Components(
                name = LIST_ITEM,
                route = ComponentsScreen.ComponentsListItem
            ),
            Components(
                name = SWIPE_TO_DISMISS,
                route = ComponentsScreen.ComponentsSwipeToDismiss
            ),
            Components(
                name = PULL_REFRESH,
                route = ComponentsScreen.ComponentsPullRefresh
            ),
            Components(
                name = RADIO_BUTTON,
                route = ComponentsScreen.ComponentsRadioButton
            ),
            Components(
                name = SWITCH,
                route = ComponentsScreen.ComponentsSwitch
            )
        )
    }
}
