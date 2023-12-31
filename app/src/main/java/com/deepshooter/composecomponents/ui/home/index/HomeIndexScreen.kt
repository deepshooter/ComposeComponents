package com.deepshooter.composecomponents.ui.home.index

import android.content.res.Configuration
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.Screen
import com.deepshooter.composecomponents.ui.theme.Blue500
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Green500
import com.deepshooter.composecomponents.ui.theme.Pink500
import com.deepshooter.composecomponents.ui.theme.Purple500
import com.deepshooter.composecomponents.ui.theme.Red500
import com.deepshooter.composecomponents.ui.theme.Yellow500
import com.deepshooter.composecomponents.utils.AppConstant.ANIMATIONS_TITLE
import com.deepshooter.composecomponents.utils.AppConstant.CLICK_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.CLICK_TITLE
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_TITLE
import com.deepshooter.composecomponents.utils.AppConstant.DARK_MODE_TITLE
import com.deepshooter.composecomponents.utils.AppConstant.GITHUB_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.GITHUB_TITLE
import com.deepshooter.composecomponents.utils.AppConstant.LIGHT_MODE_TITLE
import com.deepshooter.composecomponents.utils.AppConstant.TICTACTOE_SCREEN
import com.deepshooter.composecomponents.utils.AppConstant.TICTACTOE_TITLE
import com.deepshooter.composecomponents.utils.UIThemeController
import com.deepshooter.composecomponents.utils.Utils
import com.deepshooter.composecomponents.utils.shadow


private val menuItems = listOf(
    MenuItem(
        name = COMPONENTS_TITLE,
        icon = R.drawable.ic_round_widgets_24,
        color = Red500,
        route = Screen.Components
    ),
    MenuItem(
        name = ANIMATIONS_TITLE,
        icon = R.drawable.ic_round_animation_24,
        color = Yellow500,
        route = Screen.Animations
    ),
    MenuItem(
        name = TICTACTOE_TITLE,
        icon = R.drawable.ic_tic_tac_toe,
        color = Purple500,
        route = Screen.TicTacToe
    ),
    MenuItem(
        name = GITHUB_TITLE,
        icon = R.drawable.ic_github,
        color = Blue500,
        route = Screen.Github
    ),
    MenuItem(
        name = CLICK_TITLE,
        icon = R.drawable.ic_click,
        color = Pink500,
        route = Screen.Click
    )
)

@Composable
fun HomeIndexScreen(
    navigate: (Screen) -> Unit = {},
    turnOnDarkMode: (Boolean) -> Unit = {}
) {

    val context = LocalContext.current
    val isDark by UIThemeController.isDarkMode.collectAsState()
    val (darkModeState, onDarkModeStateChange) = remember { mutableStateOf(isDark) }
    var clickColor by remember { mutableStateOf(Pink500) }

    Scaffold(
        Modifier
            .navigationBarsPadding()
            .imePadding()
    ) { innerPadding ->

        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier.weight(1f)
            ) {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(24.dp, 8.dp, 24.dp, 24.dp)
                ) {
                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

                            Text(
                                modifier = Modifier
                                    .padding(
                                        start = 16.dp,
                                        top = 32.dp,
                                        end = 16.dp,
                                        bottom = 16.dp
                                    )
                                    .fillMaxWidth(),
                                text = stringResource(id = R.string.app_name),
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }

                    item {
                        ModuleButton(
                            name = if (darkModeState) DARK_MODE_TITLE else LIGHT_MODE_TITLE,
                            icon = if (darkModeState) {
                                R.drawable.ic_moon_stars
                            } else {
                                R.drawable.ic_brightness_high
                            },
                            color = Green500,
                            onClick = {
                                onDarkModeStateChange(!darkModeState)
                                turnOnDarkMode(!darkModeState)
                            }
                        )
                    }

                    items(menuItems) { menu ->
                        ModuleButton(
                            name = menu.name,
                            icon = menu.icon,
                            color = if (menu.route.route == CLICK_SCREEN) {
                                clickColor
                            } else {
                                menu.color
                            },
                            onClick = {
                                when (menu.route.route) {
                                    CLICK_SCREEN -> {
                                        clickColor = Color(Utils.getRandomColor())
                                    }
                                    else -> {
                                        navigate(menu.route)
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ModuleButton(
    name: String,
    @DrawableRes icon: Int,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .shadow(
                spread = 8.dp,
                alpha = .25f,
                color = color,
                radius = 8.dp,
            ),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = color
        ),
        onClick = onClick,
        contentPadding = PaddingValues(8.dp),
        elevation = null
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(id = icon),
                contentDescription = name,
                tint = LocalContentColor.current
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = name,
                color = LocalContentColor.current,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun HomeIndexScreenPreview() {
    ComposeComponentsTheme {
        HomeIndexScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeIndexScreenPreviewDark() {
    ComposeComponentsTheme {
        HomeIndexScreen()
    }
}