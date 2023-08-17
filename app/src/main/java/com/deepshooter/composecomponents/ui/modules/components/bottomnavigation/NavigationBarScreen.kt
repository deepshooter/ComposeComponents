package com.deepshooter.composecomponents.ui.modules.components.bottomnavigation

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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import com.deepshooter.composecomponents.ui.theme.Teal300
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.UIThemeController

@Composable
fun NavigationBarScreen(
    goBack: () -> Unit
) {
    NavigationBarScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationBarScreenSkeleton(
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
                "Navigation Bar",
                goBack = goBack
            )

            Divider()

            AppComponent.MediumSpacer()

            NavigationBarSimple()

            AppComponent.MediumSpacer()

            NavigationBarWithOnlySelectedLabelsSample()

            AppComponent.BigSpacer()

        }
    }

}


@Composable
private fun NavigationBarSimple() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Chat", "Status", "Calls")
    NavigationBar(containerColor = Teal300) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Green,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.Gray,
                    indicatorColor = Color.Gray
                )
            )
        }
    }
}

@Composable
private fun NavigationBarWithOnlySelectedLabelsSample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val isDark by UIThemeController.isDarkMode.collectAsState()
    val items = listOf("Chat", "Status", "Calls")
    NavigationBar(containerColor = if (isDark) Color.Black else Purple80) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                alwaysShowLabel = false
            )
        }
    }
}


@Preview
@Composable
fun NavigationBarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        NavigationBarScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NavigationBarScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        NavigationBarScreenSkeleton()
    }
}