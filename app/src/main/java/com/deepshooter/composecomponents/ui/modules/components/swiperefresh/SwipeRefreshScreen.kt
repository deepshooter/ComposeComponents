package com.deepshooter.composecomponents.ui.modules.components.swiperefresh

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Teal700
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.SWIPE_REFRESH

@Composable
fun SwipeRefreshScreen(
    goBack: () -> Unit
) {

    SwipeRefreshScreenSkeleton(goBack = goBack)

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SwipeRefreshScreenSkeleton(
    goBack: () -> Unit = {},
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
                SWIPE_REFRESH,
                goBack = goBack
            )

            Divider()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 64.dp, start = 12.dp, end = 12.dp),
            ) {

                Text(text = stringResource(R.string.pull_to_refresh_not_available))

                AppComponent.MediumSpacer()

                Text(
                    text = "Issue Tracker: https://issuetracker.google.com/issues/261760718",
                    color = Teal700,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview
@Composable
fun SwipeRefreshScreenSkeletonPreview() {
    ComposeComponentsTheme {
        SwipeRefreshScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SwipeRefreshScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        SwipeRefreshScreenSkeleton()
    }
}