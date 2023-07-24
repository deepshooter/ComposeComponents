package com.deepshooter.composecomponents.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object UIThemeController {
    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean>
        get() = _isDarkMode

    fun updateUITheme(isDarkMode: Boolean) {
        _isDarkMode.value = isDarkMode
    }
}
