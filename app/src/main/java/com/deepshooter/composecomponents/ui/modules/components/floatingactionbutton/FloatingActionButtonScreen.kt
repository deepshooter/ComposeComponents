package com.deepshooter.composecomponents.ui.modules.components.floatingactionbutton

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

        }
    }
}


@Preview
@Composable
fun FloatingActionButtonScreenSkeletonPreview() {
    ComposeComponentsTheme() {
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