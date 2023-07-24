package com.deepshooter.composecomponents.ui

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme


@Composable
fun MainScreen(
    turnOnDarkMode: (Boolean) -> Unit
) {
    MainScreenSkeleton(
        turnOnDarkMode = turnOnDarkMode
    )
}

@Composable
fun MainScreenSkeleton(
    turnOnDarkMode: (Boolean) -> Unit
) {
    val navController = rememberNavController()

    NavHostMain(
        Modifier.background(MaterialTheme.colors.background),
        navController = navController,
        turnOnDarkMode = turnOnDarkMode
    )

}


@Preview
@Composable
fun MainScreenSkeletonPreview() {
    ComposeComponentsTheme {
        MainScreenSkeleton(
            turnOnDarkMode = {}
        )
    }
}