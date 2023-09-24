package com.deepshooter.composecomponents.ui.modules.components.list.lazycolumn

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Teal700
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.STICKY_HEADER_SAMPLE


@Composable
fun LazyColumnSampleTwoScreen(
    goBack: () -> Unit
) {

    LazyColumnSampleTwoScreenSkeleton(
        goBack = goBack
    )

}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LazyColumnSampleTwoScreenSkeleton(
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
                STICKY_HEADER_SAMPLE,
                goBack = goBack
            )

            Divider()

            val sections = listOf("A", "B", "C", "D", "E", "F", "G")

            LazyColumn(reverseLayout = false) {
                sections.forEach { section ->
                    stickyHeader {
                        Text(
                            "Section $section",
                            Modifier
                                .fillMaxWidth()
                                .background(Teal700)
                                .padding(8.dp)
                        )
                    }
                    items(10) {
                        AppComponent.CustomListItem("Item $it from the section $section")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LazyColumnSampleTwoScreenSkeletonPreview() {
    ComposeComponentsTheme {
        LazyColumnSampleTwoScreenSkeleton()
    }
}

@Preview
@Composable
fun LazyColumnSampleTwoScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        LazyColumnSampleTwoScreenSkeleton()
    }
}