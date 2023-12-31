package com.deepshooter.composecomponents.ui.modules.components.topappbar

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Purple200
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppComponent.Header
import com.deepshooter.composecomponents.utils.AppConstant.TOP_APP_BAR
import com.deepshooter.composecomponents.utils.UIThemeController

@Composable
fun TopAppBarScreen(
    goBack: () -> Unit
) {
    TopAppBarScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopAppBarScreenSkeleton(
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
        ) {
            Header(
                TOP_APP_BAR,
                goBack = goBack
            )

            SimpleTopAppBar()
            AppComponent.MediumSpacer()
            FlexibleTopAppBar()
            AppComponent.MediumSpacer()
            CustomTopAppBar()

        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar() {

    val isDark by UIThemeController.isDarkMode.collectAsState()


    TopAppBar(
        title = { Text("Simple TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            // RowScope here, so these icons will be placed horizontally
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Description")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Description")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = if (isDark) Color.Black else Purple200,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlexibleTopAppBar() {

    val isDark by UIThemeController.isDarkMode.collectAsState()

    TopAppBar(title = {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Flexible TopAppBar",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = if (isDark) Color.Black else Purple200,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {

    val isDark by UIThemeController.isDarkMode.collectAsState()

    TopAppBar(
        modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp)),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Custom TopAppBar",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = if (isDark) Color.Black else Purple200,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
        )
    )
}

@Preview
@Composable
fun TopAppBarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        TopAppBarScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopAppBarScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        TopAppBarScreenSkeleton()
    }
}