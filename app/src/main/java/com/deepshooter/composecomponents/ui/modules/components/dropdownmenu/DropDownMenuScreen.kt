package com.deepshooter.composecomponents.ui.modules.components.dropdownmenu

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
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.DROPDOWN_MENU

private val ELEMENT_HEIGHT = 48.dp


@Composable
fun DropDownMenuScreen(
    goBack: () -> Unit
) {
    DropDownMenuScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DropDownMenuScreenSkeleton(
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
                DROPDOWN_MENU,
                goBack = goBack
            )

            Divider()


        }

    }

}


@Preview
@Composable
fun DropDownMenuScreenSkeletonPreview() {
    ComposeComponentsTheme {
        DropDownMenuScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DropDownMenuScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        DropDownMenuScreenSkeleton()
    }
}