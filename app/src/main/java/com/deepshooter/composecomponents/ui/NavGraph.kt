package com.deepshooter.composecomponents.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deepshooter.composecomponents.ui.components.index.ComponentsIndexScreen
import com.deepshooter.composecomponents.ui.github.GithubViewModel
import com.deepshooter.composecomponents.ui.github.GithubWebViewScreen
import com.deepshooter.composecomponents.ui.github.WebViewTarget
import com.deepshooter.composecomponents.ui.home.index.HomeIndexScreen
import com.deepshooter.composecomponents.ui.home.splash.SplashScreen
import com.deepshooter.composecomponents.ui.tictactoe.TicTacToeIndexScreen
import com.deepshooter.composecomponents.ui.tictactoe.TicTacToeViewModel
import com.deepshooter.composecomponents.utils.AppConstant.ANIMATION_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.CLICK_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_APPBAR_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.GITHUB_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.GITHUB_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.HOME_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.HOME_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.SPLASH_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.TICTACTOE_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.TICTACTOE_SCREEN

sealed class Screen(val route: String) {
    object Home : Screen(HOME_SCREEN)
    object Animations : Screen(ANIMATION_SCREEN)
    object Components : Screen(COMPONENTS_SCREEN)
    object Github : Screen(GITHUB_SCREEN)
    object TicTacToe : Screen(TICTACTOE_SCREEN)
    object Click : Screen(CLICK_SCREEN)
}

sealed class HomeScreen(val route: String) {
    object Splash : HomeScreen(SPLASH_SCREEN)
    object HomeIndex : HomeScreen(HOME_INDEX_SCREEN)
}

sealed class ComponentsScreen(val route: String) {
    object ComponentsIndex : ComponentsScreen(COMPONENTS_INDEX_SCREEN)
    object ComponentsAppBar : ComponentsScreen(COMPONENTS_APPBAR_SCREEN)

}

sealed class GithubScreen {
    object GithubIndex : HomeScreen(GITHUB_INDEX_SCREEN)
}

sealed class TicTacToeScreen {
    object TicTacToeIndex : HomeScreen(TICTACTOE_INDEX_SCREEN)
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
        addGithubScreens(
            navController = navController
        )
        addTicTacToeScreens(
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


private fun NavGraphBuilder.addGithubScreens(
    navController: NavHostController
) {

    navigation(
        route = Screen.Github.route,
        startDestination = GithubScreen.GithubIndex.route
    ) {
        addGithubWebViewScreen(
            navController = navController
        )
    }
}


private fun NavGraphBuilder.addGithubWebViewScreen(
    navController: NavHostController
) {
    composable(GithubScreen.GithubIndex.route) {
        val viewModel: GithubViewModel = hiltViewModel()

        GithubWebViewScreen(
            viewModel = viewModel,
            target = WebViewTarget.Github,
            goBack = {
                navController.popBackStack()
            }
        )
    }
}


private fun NavGraphBuilder.addTicTacToeScreens(
    navController: NavHostController
) {
    navigation(
        route = Screen.TicTacToe.route,
        startDestination = TicTacToeScreen.TicTacToeIndex.route
    ) {
        addTicTacToeScreen(
            navController = navController
        )
    }
}

private fun NavGraphBuilder.addTicTacToeScreen(
    navController: NavHostController
) {
    composable(TicTacToeScreen.TicTacToeIndex.route) {
        val viewModel: TicTacToeViewModel = hiltViewModel()
        TicTacToeIndexScreen(
            viewModel = viewModel,
            goBack = {
                navController.popBackStack()
            }
        )
    }
}