package com.deepshooter.composecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import com.deepshooter.composecomponents.ui.MainScreen
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.SharedPreferenceHelper
import com.deepshooter.composecomponents.utils.UIThemeController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        UIThemeController.updateUITheme(sharedPreferenceHelper.getDarkMode())

        setContent {
            val isDarkMode by UIThemeController.isDarkMode.collectAsState()

            ComposeComponentsTheme(darkTheme = isDarkMode) {
                MainScreen(
                    turnOnDarkMode = { turnOn ->
                        UIThemeController.updateUITheme(turnOn)
                        sharedPreferenceHelper.setDarkMode(turnOn)
                    }
                )
            }
        }
    }
}
