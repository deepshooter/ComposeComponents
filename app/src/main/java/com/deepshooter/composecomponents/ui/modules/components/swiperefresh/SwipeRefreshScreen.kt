package com.deepshooter.composecomponents.ui.modules.components.swiperefresh

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.models.ListItem
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.SWIPE_REFRESH
import com.deepshooter.composecomponents.utils.MockData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SwipeRefreshScreen(
    goBack: () -> Unit
) {

    val scope = rememberCoroutineScope()

    val items = remember { mutableStateOf(MockData.dummyListItem) }

    val isRefreshing = remember { mutableStateOf(false) }

    SwipeRefreshScreenSkeleton(
        goBack = goBack,
        items = items.value,
        isRefreshing = isRefreshing.value,
        onRefresh = {
            scope.launch {
                isRefreshing.value = true

                delay(2000)

                items.value = items.value.shuffled()

                isRefreshing.value = false
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SwipeRefreshScreenSkeleton(
    goBack: () -> Unit = {},
    items: List<ListItem>,
    isRefreshing: Boolean = false,
    onRefresh: () -> Unit = {}
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

        }
    }
}

@Preview
@Composable
fun SwipeRefreshScreenSkeletonPreview() {
    ComposeComponentsTheme {
        val items = remember { mutableStateOf(MockData.dummyListItem) }

        SwipeRefreshScreenSkeleton(
            items = items.value
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SwipeRefreshScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        val items = remember { mutableStateOf(MockData.dummyListItem) }

        SwipeRefreshScreenSkeleton(
            items = items.value
        )
    }
}