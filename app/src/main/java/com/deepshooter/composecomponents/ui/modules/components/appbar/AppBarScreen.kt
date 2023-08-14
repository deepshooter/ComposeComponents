package com.deepshooter.composecomponents.ui.modules.components.appbar

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppComponent.Header

@Composable
fun AppBarScreen(
    goBack: () -> Unit
) {
    AppBarScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppBarScreenSkeleton(
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
                "App Bar",
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
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlexibleTopAppBar() {
    TopAppBar(title = {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Flexible TopAppBar",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {

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
        })
}

@Preview
@Composable
fun AppBarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        AppBarScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppBarScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        AppBarScreenSkeleton()
    }
}