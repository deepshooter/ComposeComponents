package com.deepshooter.composecomponents.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deepshooter.composecomponents.ui.modules.components.topappbar.TopAppBarScreen
import com.deepshooter.composecomponents.ui.modules.components.index.ComponentsIndexScreen
import com.deepshooter.composecomponents.ui.modules.github.GithubViewModel
import com.deepshooter.composecomponents.ui.modules.github.GithubWebViewScreen
import com.deepshooter.composecomponents.ui.modules.github.WebViewTarget
import com.deepshooter.composecomponents.ui.home.index.HomeIndexScreen
import com.deepshooter.composecomponents.ui.home.splash.SplashScreen
import com.deepshooter.composecomponents.ui.modules.animations.animatedimage.AnimatedImageScreen
import com.deepshooter.composecomponents.ui.modules.animations.animatedtext.AnimatedTextScreen
import com.deepshooter.composecomponents.ui.modules.animations.bubbles.BubblesScreen
import com.deepshooter.composecomponents.ui.modules.animations.index.AnimationIndexScreen
import com.deepshooter.composecomponents.ui.modules.components.badge.BadgeScreen
import com.deepshooter.composecomponents.ui.modules.components.button.ButtonScreen
import com.deepshooter.composecomponents.ui.modules.components.card.CardScreen
import com.deepshooter.composecomponents.ui.modules.components.checkbox.CheckBoxScreen
import com.deepshooter.composecomponents.ui.modules.components.dialog.DialogScreen
import com.deepshooter.composecomponents.ui.modules.components.dropdownmenu.DropDownMenuScreen
import com.deepshooter.composecomponents.ui.modules.components.floatingactionbutton.FloatingActionButtonScreen
import com.deepshooter.composecomponents.ui.modules.components.list.LazyRowScreen
import com.deepshooter.composecomponents.ui.modules.components.list.LazyVerticalGridScreen
import com.deepshooter.composecomponents.ui.modules.components.list.ListColumnScreen
import com.deepshooter.composecomponents.ui.modules.components.list.ListIndexScreen
import com.deepshooter.composecomponents.ui.modules.components.list.ListRowScreen
import com.deepshooter.composecomponents.ui.modules.components.list.lazycolumn.LazyColumnIndexScreen
import com.deepshooter.composecomponents.ui.modules.components.navigationbar.NavigationBarScreen
import com.deepshooter.composecomponents.ui.modules.components.progressindicator.ProgressIndicatorScreen
import com.deepshooter.composecomponents.ui.modules.components.scaffold.ScaffoldIndexScreen
import com.deepshooter.composecomponents.ui.modules.components.scaffold.ScaffoldWithBottomBarScreen
import com.deepshooter.composecomponents.ui.modules.components.scaffold.ScaffoldWithCoroutinesSnackbarScreen
import com.deepshooter.composecomponents.ui.modules.components.scaffold.ScaffoldWithCustomSnackbarScreen
import com.deepshooter.composecomponents.ui.modules.components.scaffold.ScaffoldWithSimpleSnackbarScreen
import com.deepshooter.composecomponents.ui.modules.components.scaffold.SimpleScaffoldWithTopBarScreen
import com.deepshooter.composecomponents.ui.modules.components.slider.SliderScreen
import com.deepshooter.composecomponents.ui.modules.components.snackbar.SnackBarScreen
import com.deepshooter.composecomponents.ui.modules.components.text.TextScreen
import com.deepshooter.composecomponents.ui.modules.components.textfield.TextFieldScreen
import com.deepshooter.composecomponents.ui.modules.tictactoe.TicTacToeIndexScreen
import com.deepshooter.composecomponents.ui.modules.tictactoe.TicTacToeViewModel
import com.deepshooter.composecomponents.utils.AppConstant.ANIMATIONS_ANIMATED_IMAGE_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.ANIMATIONS_ANIMATED_TEXT_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.ANIMATIONS_BUBBLES_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.ANIMATIONS_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.ANIMATION_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.CLICK_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_BADGE_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_BUTTON_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_CARD_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_CHECKBOX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_DIALOG_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_DROPDOWN_MENU_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_FLOATING_ACTION_BUTTON_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_TOP_APPBAR_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_LIST_COLUMN_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_LIST_GRID_VERTICAL_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_LIST_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_LIST_LAZY_COLUMN_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_LIST_LAZY_COLUMN_ONE_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_LIST_LAZY_COLUMN_TWO_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_LIST_LAZY_ROW_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_LIST_ROW_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_NAVIGATION_BAR_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_PROGRESS_INDICATOR_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCAFFOLD_FIVE_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCAFFOLD_FOUR_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCAFFOLD_INDEX_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCAFFOLD_ONE_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCAFFOLD_THREE_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCAFFOLD_TWO_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SLIDER_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SNACKBAR_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_TEXT_FIELD_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_TEXT_SCREEN
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
    object ComponentsText : ComponentsScreen(COMPONENTS_TEXT_SCREEN)
    object ComponentsTextField : ComponentsScreen(COMPONENTS_TEXT_FIELD_SCREEN)
    object ComponentsButton : ComponentsScreen(COMPONENTS_BUTTON_SCREEN)
    object ComponentsFloatingActionButton : ComponentsScreen(COMPONENTS_FLOATING_ACTION_BUTTON_SCREEN)
    object ComponentsCard : ComponentsScreen(COMPONENTS_CARD_SCREEN)
    object ComponentsDropDownMenu : ComponentsScreen(COMPONENTS_DROPDOWN_MENU_SCREEN)
    object ComponentsCheckBox : ComponentsScreen(COMPONENTS_CHECKBOX_SCREEN)
    object ComponentsDialog : ComponentsScreen(COMPONENTS_DIALOG_SCREEN)
    object ComponentsTopAppBar : ComponentsScreen(COMPONENTS_TOP_APPBAR_SCREEN)
    object ComponentsNavigationBar : ComponentsScreen(COMPONENTS_NAVIGATION_BAR_SCREEN)
    object ComponentsBadge : ComponentsScreen(COMPONENTS_BADGE_SCREEN)
    object ComponentsSlider : ComponentsScreen(COMPONENTS_SLIDER_SCREEN)
    object ComponentsProgressIndicator : ComponentsScreen(COMPONENTS_PROGRESS_INDICATOR_SCREEN)
    object ComponentsSnackBar : ComponentsScreen(COMPONENTS_SNACKBAR_SCREEN)
    object ComponentsScaffoldIndex : ComponentsScreen(COMPONENTS_SCAFFOLD_INDEX_SCREEN)
    object ComponentsScaffoldOne : ComponentsScreen(COMPONENTS_SCAFFOLD_ONE_SCREEN)
    object ComponentsScaffoldTwo : ComponentsScreen(COMPONENTS_SCAFFOLD_TWO_SCREEN)
    object ComponentsScaffoldThree : ComponentsScreen(COMPONENTS_SCAFFOLD_THREE_SCREEN)
    object ComponentsScaffoldFour : ComponentsScreen(COMPONENTS_SCAFFOLD_FOUR_SCREEN)
    object ComponentsScaffoldFive : ComponentsScreen(COMPONENTS_SCAFFOLD_FIVE_SCREEN)
    object ComponentsListIndex : ComponentsScreen(COMPONENTS_LIST_INDEX_SCREEN)
    object ComponentsListColumn : ComponentsScreen(COMPONENTS_LIST_COLUMN_SCREEN)
    object ComponentsListRow : ComponentsScreen(COMPONENTS_LIST_ROW_SCREEN)
    object ComponentsListLazyRow : ComponentsScreen(COMPONENTS_LIST_LAZY_ROW_SCREEN)
    object ComponentsListGridVertical : ComponentsScreen(COMPONENTS_LIST_GRID_VERTICAL_SCREEN)
    object ComponentsListLazyColumnIndex : ComponentsScreen(COMPONENTS_LIST_LAZY_COLUMN_INDEX_SCREEN)
    object ComponentsListLazyColumnOne : ComponentsScreen(COMPONENTS_LIST_LAZY_COLUMN_ONE_SCREEN)
    object ComponentsListLazyColumnTwo : ComponentsScreen(COMPONENTS_LIST_LAZY_COLUMN_TWO_SCREEN)



}

sealed class GithubScreen {
    object GithubIndex : HomeScreen(GITHUB_INDEX_SCREEN)
}

sealed class TicTacToeScreen {
    object TicTacToeIndex : HomeScreen(TICTACTOE_INDEX_SCREEN)
}


sealed class AnimationsScreen(val route: String) {
    object AnimationsIndex : AnimationsScreen(ANIMATIONS_INDEX_SCREEN)
    object AnimationsBubbles : AnimationsScreen(ANIMATIONS_BUBBLES_SCREEN)
    object AnimationsAnimatedText : AnimationsScreen(ANIMATIONS_ANIMATED_TEXT_SCREEN)
    object AnimationsAnimatedImage : AnimationsScreen(ANIMATIONS_ANIMATED_IMAGE_SCREEN)

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
        addAnimationsScreens(
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

        //Text
        composable(ComponentsScreen.ComponentsText.route) {
            TextScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //TextField
        composable(ComponentsScreen.ComponentsTextField.route) {
            TextFieldScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //Button
        composable(ComponentsScreen.ComponentsButton.route) {
            ButtonScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //FloatingActionButton
        composable(ComponentsScreen.ComponentsFloatingActionButton.route) {
            FloatingActionButtonScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //Card
        composable(ComponentsScreen.ComponentsCard.route) {
            CardScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //DropDownMenu
        composable(ComponentsScreen.ComponentsDropDownMenu.route) {
            DropDownMenuScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //CheckBox
        composable(ComponentsScreen.ComponentsCheckBox.route) {
            CheckBoxScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //Dialog
        composable(ComponentsScreen.ComponentsDialog.route) {
            DialogScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //TopAppBar
        composable(ComponentsScreen.ComponentsTopAppBar.route) {
            TopAppBarScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //NavigationBar
        composable(ComponentsScreen.ComponentsNavigationBar.route) {
            NavigationBarScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //Badge
        composable(ComponentsScreen.ComponentsBadge.route) {
            BadgeScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //Slider
        composable(ComponentsScreen.ComponentsSlider.route) {
            SliderScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //ProgressIndicator
        composable(ComponentsScreen.ComponentsProgressIndicator.route) {
            ProgressIndicatorScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //SnackBar
        composable(ComponentsScreen.ComponentsSnackBar.route) {
            SnackBarScreen(
                goBack = {
                    navController.popBackStack()
                },
                navigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        //Scaffold
        composable(ComponentsScreen.ComponentsScaffoldIndex.route) {
            ScaffoldIndexScreen(
                goBack = {
                    navController.popBackStack()
                },
                navigate = { screen ->
                    navController.navigate(screen.route)
                }
            )
        }

        //SimpleScaffoldWithTopBar
        composable(ComponentsScreen.ComponentsScaffoldOne.route) {
            SimpleScaffoldWithTopBarScreen()
        }

        //ScaffoldWithBottomBar
        composable(ComponentsScreen.ComponentsScaffoldTwo.route) {
            ScaffoldWithBottomBarScreen()
        }

        //ScaffoldWithSimpleSnackbar
        composable(ComponentsScreen.ComponentsScaffoldThree.route) {
            ScaffoldWithSimpleSnackbarScreen()
        }

        //ScaffoldWithCustomSnackbar
        composable(ComponentsScreen.ComponentsScaffoldFour.route) {
            ScaffoldWithCustomSnackbarScreen()
        }

        //ScaffoldWithCoroutinesSnackbar
        composable(ComponentsScreen.ComponentsScaffoldFive.route) {
            ScaffoldWithCoroutinesSnackbarScreen()
        }

        //List
        composable(ComponentsScreen.ComponentsListIndex.route) {
            ListIndexScreen(goBack = {
                navController.popBackStack()
            }, navigate = { screen ->
                navController.navigate(screen.route)
            })
        }

        //ListWithColumn
        composable(ComponentsScreen.ComponentsListColumn.route) {
            ListColumnScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //ListWithRow
        composable(ComponentsScreen.ComponentsListRow.route) {
            ListRowScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //ListWithLazyRow
        composable(ComponentsScreen.ComponentsListLazyRow.route) {
            LazyRowScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //LazyVerticalGrid
        composable(ComponentsScreen.ComponentsListGridVertical.route) {
            LazyVerticalGridScreen(
                goBack = {
                    navController.popBackStack()
                }
            )
        }

        //LazyColumn
        composable(ComponentsScreen.ComponentsListLazyColumnIndex.route) {
            LazyColumnIndexScreen(
                goBack = {
                    navController.popBackStack()
                },
                navigate = { screen ->
                    navController.navigate(screen.route)
                }
            )
        }

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

private fun NavGraphBuilder.addAnimationsScreens(
    navController: NavHostController
) {

    navigation(
        route = Screen.Animations.route,
        startDestination = AnimationsScreen.AnimationsIndex.route
    ) {
        addAnimationsIndexScreen(
            navController = navController
        )

    }

    composable(AnimationsScreen.AnimationsBubbles.route) {
        BubblesScreen()
    }

    composable(AnimationsScreen.AnimationsAnimatedText.route) {
       AnimatedTextScreen()
    }

    composable(AnimationsScreen.AnimationsAnimatedImage.route) {
        AnimatedImageScreen()
    }
}

private fun NavGraphBuilder.addAnimationsIndexScreen(
    navController: NavHostController
) {
    composable(AnimationsScreen.AnimationsIndex.route) {
        AnimationIndexScreen(
            goBack = {
                navController.popBackStack()
            },
            navigate = { screen ->
                navController.navigate(screen.route)
            }
        )
    }
}