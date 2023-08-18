package com.deepshooter.composecomponents.ui.modules.components.text

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.TEXT


@Composable
fun TextScreen(
    goBack: () -> Unit
) {
    TextScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TextScreenSkeleton(
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

            AppComponent.Header(
                TEXT,
                goBack = goBack
            )

            Divider()
        }
    }
}

@Preview
@Composable
fun TextScreenSkeletonPreview() {
    ComposeComponentsTheme {
        TextScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        TextScreenSkeleton()
    }
}