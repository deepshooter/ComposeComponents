package com.deepshooter.composecomponents.ui.modules.components.list.lazycolumn

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.BASIC_SAMPLE


@Composable
fun LazyColumnSampleOneScreen(
    goBack: () -> Unit
) {

    LazyColumnSampleOneScreenSkeleton(
        goBack = goBack
    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LazyColumnSampleOneScreenSkeleton(
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
                BASIC_SAMPLE,
                goBack = goBack
            )

            Divider()

            val itemsList = (0..10).toList()
            val itemsIndexedList = listOf("A", "B", "C", "D", "E", "F", "G")

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(0.dp, 8.dp)
            ) {
                items(itemsList) {
                    AppComponent.CustomListItem("Item is $it")
                }

                item {
                    AppComponent.CustomListItem("Single item")
                }

                itemsIndexed(itemsIndexedList) { index, item ->
                    AppComponent.CustomListItem("Item at index $index is $item")
                }
            }
        }
    }
}

@Preview
@Composable
fun LazyColumnSampleOneScreenSkeletonPreview() {
    ComposeComponentsTheme {
        LazyColumnSampleOneScreenSkeleton()
    }
}

@Preview
@Composable
fun LazyColumnSampleOneScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        LazyColumnSampleOneScreenSkeleton()
    }
}