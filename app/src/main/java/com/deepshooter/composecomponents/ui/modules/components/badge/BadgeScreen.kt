package com.deepshooter.composecomponents.ui.modules.components.badge

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Purple80
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.BADGE
import com.deepshooter.composecomponents.utils.UIThemeController


@Composable
fun BadgeScreen(
    goBack: () -> Unit
) {
    BadgeScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BadgeScreenSkeleton(
    goBack: () -> Unit = {}
) {

    Scaffold(
        Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            AppComponent.Header(
                BADGE,
                goBack = goBack
            )

            Divider()

            AppComponent.MediumSpacer()

            NavigationBarItemWithBadge()

            AppComponent.BigSpacer()

        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarItemWithBadge() {

    var homeCounter by remember { mutableIntStateOf(0) }
    var favoriteCounter by remember { mutableIntStateOf(0) }
    var profileCounter by remember { mutableIntStateOf(0) }
    val isDark by UIThemeController.isDarkMode.collectAsState()

    NavigationBar(containerColor = if (isDark) Color.Black else Purple80) {
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge { Text("$homeCounter") } }) {
                    Icon(
                        Icons.Rounded.Home,
                        contentDescription = "Home"
                    )
                }
            },
            selected = true,
            onClick = {
                homeCounter++
            }
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = {
                    if (favoriteCounter > 0) {
                        Badge {
                            Text(if (favoriteCounter > 9) "9+" else "$favoriteCounter")
                        }
                    }
                }) {
                    Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = "Favorite"
                    )
                }
            },
            selected = false,
            onClick = {
                favoriteCounter++
            }
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = {
                    Badge {
                        Text(
                            if (profileCounter > 9) {
                                "infinite"
                            } else {
                                profileCounter.toString()
                            }
                        )
                    }
                }) {
                    Icon(
                        Icons.Rounded.Person,
                        contentDescription = "Profile"
                    )
                }
            },
            selected = false,
            onClick = {
                profileCounter++
            }
        )
    }
}

@Preview
@Composable
fun BadgeScreenSkeletonPreview() {
    ComposeComponentsTheme {
        BadgeScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BadgeScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        BadgeScreenSkeleton()
    }
}