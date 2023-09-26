package com.deepshooter.composecomponents.ui.modules.components.radiobutton

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.RADIO_BUTTON

private val ELEMENT_HEIGHT = 56.dp


@Composable
fun RadioButtonScreen(
    goBack: () -> Unit
) {
    RadioButtonScreenSkeleton(
        goBack = goBack
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RadioButtonScreenSkeleton(
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
                RADIO_BUTTON,
                goBack = goBack
            )

            Divider()

        }
    }
}


@Preview
@Composable
fun RadioButtonScreenSkeletonPreview() {
    ComposeComponentsTheme {
        RadioButtonScreenSkeleton()
    }
}
