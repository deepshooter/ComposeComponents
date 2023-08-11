package com.deepshooter.composecomponents.ui.components.appbar

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme

@Composable
fun AppBarScreen(
    goBack: () -> Unit
) {
    AppBarScreenSkeleton(
        goBack = goBack
    )
}

@Composable
fun AppBarScreenSkeleton(
    goBack: () -> Unit = {}
) {

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