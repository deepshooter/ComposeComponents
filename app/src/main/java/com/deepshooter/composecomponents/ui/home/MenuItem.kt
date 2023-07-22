package com.deepshooter.composecomponents.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.deepshooter.composecomponents.ui.Screen

data class MenuItem(
    val name: String,
    @DrawableRes val icon: Int,
    val color: Color,
    val route: Screen
)
