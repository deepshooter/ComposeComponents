package com.deepshooter.composecomponents.ui.modules.components.list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.deepshooter.composecomponents.utils.AppConstant.LIST_WITH_LAZY_ROW

@Composable
fun LazyRowScreen(
    goBack: () -> Unit
) {
    LazyRowScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LazyRowScreenSkeleton(
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
                LIST_WITH_LAZY_ROW,
                goBack = goBack
            )

            Divider()

            val itemsList = (0..5).toList()
            val itemsIndexedList = listOf("A", "B", "C")

            LazyRow(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(8.dp, 8.dp)
            ) {
                items(itemsList) {
                    CustomItemList("Item is $it")
                }

                item {
                    CustomItemList("Single item")
                }

                itemsIndexed(itemsIndexedList) { index, item ->
                    CustomItemList("Item at index $index is $item")
                }
            }
        }
    }
}

@Composable
private fun CustomItemList(
    text: String
) {
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
        text = text,
        textAlign = TextAlign.Center
    )
}


@Preview
@Composable
fun LazyRowScreenSkeletonPreview() {
    ComposeComponentsTheme {
        LazyRowScreenSkeleton()
    }
}

@Preview
@Composable
fun LazyRowScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        LazyRowScreenSkeleton()
    }
}