package com.deepshooter.composecomponents.ui.modules.components.dialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
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
import com.deepshooter.composecomponents.utils.AppConstant.DIALOG


@Composable
fun DialogScreen(
    goBack: () -> Unit
) {

}


@Composable
fun DialogScreenSkeleton(
    goBack: () -> Unit = {},
    showDefaultDialog: () -> Unit = {},
    showCustomDialog: () -> Unit = {}
) {

    Scaffold(
        Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding()
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AppComponent.Header(
                DIALOG,
                goBack = goBack
            )

            Divider()


        }
    }

}

@Preview
@Composable
fun DialogScreenSkeletonPreview() {
    ComposeComponentsTheme {
        DialogScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DialogScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        DialogScreenSkeleton()
    }
}