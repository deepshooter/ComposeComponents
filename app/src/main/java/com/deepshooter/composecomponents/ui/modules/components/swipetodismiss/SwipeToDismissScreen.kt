package com.deepshooter.composecomponents.ui.modules.components.swipetodismiss

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.models.ListItem
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.SWIPE_TO_DISMISS
import com.deepshooter.composecomponents.utils.MockData


private val dummyItems = MockData.dummyListItem.toList()

@Composable
fun SwipeToDismissScreen(
    goBack: () -> Unit
) {
    val items = remember { mutableStateOf(dummyItems) }

    SwipeToDismissScreenSkeleton(
        goBack = goBack,
        items = items.value,
        onDelete = {
            items.value = items.value.toMutableList().apply {
                remove(it)
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SwipeToDismissScreenSkeleton(
    goBack: () -> Unit = {},
    items: List<ListItem>,
    onDelete: (ListItem) -> Unit
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
                SWIPE_TO_DISMISS,
                goBack = goBack
            )

            Divider()


        }
    }
}

@Preview
@Composable
fun SwipeToDismissScreenSkeletonPreview() {
    ComposeComponentsTheme {
        val items = remember { mutableStateOf(dummyItems) }

        SwipeToDismissScreenSkeleton(
            items = items.value,
            onDelete = {
                items.value = items.value.toMutableList().apply {
                    remove(it)
                }
            }
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SwipeToDismissScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        val items = remember { mutableStateOf(dummyItems) }

        SwipeToDismissScreenSkeleton(
            items = items.value,
            onDelete = {
                items.value = items.value.toMutableList().apply {
                    remove(it)
                }
            }
        )
    }
}