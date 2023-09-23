package com.deepshooter.composecomponents.ui.modules.components.list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.LIST_WITH_ROW

@Composable
fun ListRowScreen(
    goBack: () -> Unit
) {
    ListRowScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListRowScreenSkeleton(
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
                LIST_WITH_ROW,
                goBack = goBack
            )

            Divider()

            val scrollState = rememberScrollState()

            Row(
                Modifier
                    .fillMaxSize()
                    .horizontalScroll(scrollState)
                    .padding(8.dp, 8.dp)
            ) {
                for (i in 1..50) {
                    Text(
                        modifier = Modifier
                            .padding(4.dp)
                            .shadow(2.dp, RoundedCornerShape(8.dp))
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                // do things here.
                            }
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(32.dp, 32.dp),
                        text = "$i\nNumber\nItem",
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ListRowScreenSkeletonPreview() {
    ComposeComponentsTheme {
        ListRowScreenSkeleton()
    }
}

@Preview
@Composable
fun ListRowScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        ListRowScreenSkeleton()
    }
}