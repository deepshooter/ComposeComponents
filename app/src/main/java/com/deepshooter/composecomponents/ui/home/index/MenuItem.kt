package com.deepshooter.composecomponents.ui.home.index

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.deepshooter.composecomponents.ui.Screen

data class MenuItem(
    val name: String,
    @DrawableRes val icon: Int,
    var color: Color,
    val route: Screen
)
