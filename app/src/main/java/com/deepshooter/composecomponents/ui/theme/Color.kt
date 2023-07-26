package com.deepshooter.composecomponents.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


// colors.trueGray
val Gray50 = Color(0xFFFAFAFA)
val Gray100 = Color(0xFFF5F5F5)
val Gray200 = Color(0xFFE5E5E5)
val Gray300 = Color(0xFFD4D4D4)
val Gray400 = Color(0xFFA3A3A3)
val Gray500 = Color(0xFF737373)
val Gray600 = Color(0xFF525252)
val Gray700 = Color(0xFF404040)
val Gray800 = Color(0xFF262626)
val Gray900 = Color(0xFF171717)

// colors.red
val Red500 = Color(0xFFEF4444)
val Red700 = Color(0xFFB91C1C)
val Red900 = Color(0xFF7F1D1D)

// colors.amber
val Yellow500 = Color(0xFFF59E0B)
val Yellow700 = Color(0xFFB45309)
val Yellow900 = Color(0xFF78350F)

// colors.emerald
val Green500 = Color(0xFF10B981)
val Green700 = Color(0xFF047857)
val Green900 = Color(0xFF064E3B)

// colors.blue
val Blue500 = Color(0xFF3B82F6)
val Blue700 = Color(0xFF1D4ED8)
val Blue900 = Color(0xFF1E3A8A)

// colors.indigo
val Indigo500 = Color(0xFF6366F1)
val Indigo700 = Color(0xFF4338CA)
val Indigo900 = Color(0xFF312E81)

// colors.violet
val Purple500 = Color(0xFF8B5CF6)
val Purple700 = Color(0xFF6D28D9)
val Purple900 = Color(0xFF4C1D95)

// colors.pink
val Pink500 = Color(0xFFEC4899)
val Pink700 = Color(0xFFBE185D)
val Pink900 = Color(0xFF831843)


val dotBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Gray800 else Gray200