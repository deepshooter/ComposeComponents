package com.deepshooter.composecomponents.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Green700,
    secondary = Pink700,
    background = Gray900,
    surface = Color.Black,
    error = Red700,

    onPrimary = Gray50,
    onSecondary = Gray50,
    onBackground = Gray50,
    onSurface = Gray50
)

private val LightColorScheme = lightColorScheme(
    primary = Green500,
    secondary = Pink500,
    background = Gray50,
    surface = Color.White,
    error = Red500,

    onPrimary = Gray50,
    onSecondary = Gray50,
    onBackground = Gray900,
    onSurface = Gray900
)

@Composable
fun ComposeComponentsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !darkTheme
        )
    }

    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}