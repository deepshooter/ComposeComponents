package com.deepshooter.composecomponents.ui.modules.components.floatingactionbutton

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.FLOATING_ACTION_BUTTON


@Composable
fun FloatingActionButtonScreen(
    goBack: () -> Unit
) {
    FloatingActionButtonScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FloatingActionButtonScreenSkeleton(
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
                FLOATING_ACTION_BUTTON,
                goBack = goBack
            )

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppComponent.MediumSpacer()

                FloatingActionButton(onClick = { /*do something*/ }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = stringResource(id = R.string.localized_description)
                    )
                }

                AppComponent.MediumSpacer()

                ExtendedFloatingActionButton(
                    content = { Text(stringResource(R.string.extended)) },
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                ExtendedFloatingActionButton(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    text = { Text(stringResource(R.string.add_to_basket)) },
                    onClick = { /*do something*/ }
                )

                AppComponent.MediumSpacer()

                ExtendedFloatingActionButton(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    text = { Text(stringResource(R.string.fluid_fab)) },
                    onClick = { /*do something*/ },
                    modifier = Modifier.fillMaxWidth()
                )

            }

            AppComponent.BigSpacer()
        }
    }
}


@Preview
@Composable
fun FloatingActionButtonScreenSkeletonPreview() {
    ComposeComponentsTheme {
        FloatingActionButtonScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FloatingActionButtonScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        FloatingActionButtonScreenSkeleton()
    }
}