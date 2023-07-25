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
    primary = TailwindCSSColor.Green700,
    //primaryVariant = TailwindCSSColor.Green900,
    secondary = TailwindCSSColor.Pink700,
    //secondaryVariant = TailwindCSSColor.Pink900,
    background = TailwindCSSColor.Gray900,
    surface = Color.Black,
    error = TailwindCSSColor.Red700,

    onPrimary = TailwindCSSColor.Gray50,
    onSecondary = TailwindCSSColor.Gray50,
    onBackground = TailwindCSSColor.Gray50,
    onSurface = TailwindCSSColor.Gray50
)

private val LightColorScheme = lightColorScheme(
    primary = TailwindCSSColor.Green500,
    //primaryVariant = TailwindCSSColor.Green700,
    secondary = TailwindCSSColor.Pink500,
    //secondaryVariant = TailwindCSSColor.Pink700,
    background = TailwindCSSColor.Gray50,
    surface = Color.White,
    error = TailwindCSSColor.Red500,

    onPrimary = TailwindCSSColor.Gray50,
    onSecondary = TailwindCSSColor.Gray50,
    onBackground = TailwindCSSColor.Gray900,
    onSurface = TailwindCSSColor.Gray900
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