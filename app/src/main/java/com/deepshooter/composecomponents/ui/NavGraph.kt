package com.deepshooter.composecomponents.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deepshooter.composecomponents.ui.components.index.ComponentsIndexScreen
import com.deepshooter.composecomponents.ui.home.index.HomeIndexScreen
import com.deepshooter.composecomponents.ui.home.splash.SplashScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Animations : Screen("animation")
    object Components : Screen("components")
    object UIs : Screen("ui")
    object Tutorials : Screen("tutorial")
}

sealed class HomeScreen(val route: String) {
    object Splash : HomeScreen("splash")
    object HomeIndex : HomeScreen("home/index")
}

sealed class ComponentsScreen(val route: String) {
    object ComponentsIndex : ComponentsScreen("components/index")

    object ComponentsAppBar : ComponentsScreen("components/appbar")

}

@Composable
fun NavHostMain(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    turnOnDarkMode: (Boolean) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        addHomeScreens(
            navController = navController,
            turnOnDarkMode = turnOnDarkMode
        )
        addComponentsScreens(
            navController = navController
        )
    }
}


private fun NavGraphBuilder.addHomeScreens(
    navController: NavHostController,
    turnOnDarkMode: (Boolean) -> Unit
) {
    navigation(
        route = Screen.Home.route,
        startDestination = HomeScreen.Splash.route
    ) {
        addHomeSplashScreen(
            navController = navController
        )
        addHomeIndexScreen(
            navController = navController,
            turnOnDarkMode = turnOnDarkMode
        )
    }
}

private fun NavGraphBuilder.addHomeSplashScreen(
    navController: NavHostController
) {
    composable(HomeScreen.Splash.route) {
        SplashScreen(
            gotoHomeIndex = {
                navController.navigate(HomeScreen.HomeIndex.route) {
                    popUpTo(HomeScreen.Splash.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

private fun NavGraphBuilder.addHomeIndexScreen(
    navController: NavHostController,
    turnOnDarkMode: (Boolean) -> Unit
) {
    composable(HomeScreen.HomeIndex.route) {
        HomeIndexScreen(
            navigate = { screen ->
                navController.navigate(screen.route)
            },
            turnOnDarkMode = turnOnDarkMode
        )
    }
}

private fun NavGraphBuilder.addComponentsScreens(
    navController: NavHostController
) {

    navigation(
        route = Screen.Components.route,
        startDestination = ComponentsScreen.ComponentsIndex.route
    ) {
        addComponentsIndexScreen(
            navController = navController
        )
    }
}

private fun NavGraphBuilder.addComponentsIndexScreen(
    navController: NavHostController
) {
    composable(ComponentsScreen.ComponentsIndex.route) {
        ComponentsIndexScreen(
            goBack = {
                navController.popBackStack()
            },
            navigate = { screen ->
                navController.navigate(screen.route)
            }
        )
    }
}