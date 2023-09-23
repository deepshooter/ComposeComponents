package com.deepshooter.composecomponents.ui.modules.components.list

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.GRID_WITH_LAZY_VERTICAL_GRID
import com.deepshooter.composecomponents.utils.rememberImagePainter


@Composable
fun LazyVerticalGridScreen(
    goBack: () -> Unit
) {

    LazyVerticalGridScreenSkeleton(
        goBack = goBack
    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LazyVerticalGridScreenSkeleton(
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
                GRID_WITH_LAZY_VERTICAL_GRID,
                goBack = goBack
            )

            Divider()

            AppComponent.SubHeader(
                text = stringResource(R.string.adaptive_columns)
            )

            Divider()

            val itemsList = (1..102).toList()

            LazyVerticalGrid(
                columns = GridCells.Adaptive(64.dp),
                modifier = Modifier
                    .weight(1f)
            ) {

                items(itemsList) { item ->
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        painter = rememberImagePainter(
                            data = "https://picsum.photos/seed/$item/128",
                            crossFade = true
                        ),
                        contentDescription = null
                    )
                }

                // We can also use:
                // - item {}
                // - itemsIndexed(items) { index, item -> }
            }

            Divider()

            AppComponent.SubHeader(
                text = stringResource(R.string.fixed_columns)
            )

            Divider()

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .weight(1f)
            ) {
                items(itemsList) { item ->
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        painter = rememberImagePainter(
                            data = "https://picsum.photos/seed/$item/200",
                            crossFade = true
                        ),
                        contentDescription = null
                    )
                }

                // We can also use:
                // - item {}
                // - itemsIndexed(items) { index, item -> }
            }
        }
    }
}

@Preview
@Composable
fun LazyVerticalGridScreenSkeletonPreview() {
    ComposeComponentsTheme {
        LazyVerticalGridScreenSkeleton()
    }
}

@Preview
@Composable
fun LazyVerticalGridScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        LazyVerticalGridScreenSkeleton()
    }
}