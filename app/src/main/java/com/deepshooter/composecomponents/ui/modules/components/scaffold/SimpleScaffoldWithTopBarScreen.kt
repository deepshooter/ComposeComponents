package com.deepshooter.composecomponents.ui.modules.components.scaffold

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer.AllDestinations
import com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer.AppDrawer
import com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer.AppNavigationActions
import com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer.HomeScreen
import com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer.SettingsScreen
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun SimpleScaffoldWithTopBarScreen() {
    SimpleScaffoldWithTopBarScreenSkeleton()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleScaffoldWithTopBarScreenSkeleton() {

    val navController: NavHostController = rememberNavController()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.HOME
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }

    ModalNavigationDrawer(drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateToHome = { navigationActions.navigateToHome() },
            navigateToSettings = { navigationActions.navigateToSettings() },
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier = Modifier
        )
    }, drawerState = drawerState) {

        Scaffold(
            modifier = Modifier
                .navigationBarsPadding()
                .imePadding()
                .statusBarsPadding(),
            topBar = {
                TopAppBar(
                    title = { Text(text = currentRoute) },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = stringResource(id = R.string.localized_description)
                            )
                        }
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    content = { Text(stringResource(R.string.extended_fab)) },
                    onClick = { /* fab click handler */ }
                )
            },
            content = {
                //Drawer Menu Screens
                NavHost(navController = navController, startDestination = AllDestinations.HOME) {
                    composable(AllDestinations.HOME) {
                        HomeScreen()
                    }

                    composable(AllDestinations.SETTINGS) {
                        SettingsScreen()
                    }
                }
            }
        )

    }
}

@Preview
@Composable
fun SimpleScaffoldWithTopBarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        SimpleScaffoldWithTopBarScreenSkeleton()
    }
}

@Preview
@Composable
fun SimpleScaffoldWithTopBarScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        SimpleScaffoldWithTopBarScreenSkeleton()
    }
}
