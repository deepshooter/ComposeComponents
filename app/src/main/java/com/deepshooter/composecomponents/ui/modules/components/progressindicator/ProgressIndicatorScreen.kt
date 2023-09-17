package com.deepshooter.composecomponents.ui.modules.components.progressindicator

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.PROGRESS_INDICATOR


@Composable
fun ProgressIndicatorScreen(
    goBack: () -> Unit
) {

    ProgressIndicatorScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProgressIndicatorScreenSkeleton(
    goBack: () -> Unit = {}
) {

    var showLoading by remember { mutableStateOf(false) }


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
                PROGRESS_INDICATOR,
                goBack = goBack
            )

            Divider()

        }
    }
}


@Preview
@Composable
fun ProgressIndicatorScreenSkeletonPreview() {
    ComposeComponentsTheme {
        ProgressIndicatorScreenSkeleton()
    }
}

@Preview
@Composable
fun ProgressIndicatorScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        ProgressIndicatorScreenSkeleton()
    }
}