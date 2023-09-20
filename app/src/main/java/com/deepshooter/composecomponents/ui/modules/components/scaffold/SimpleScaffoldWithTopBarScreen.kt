package com.deepshooter.composecomponents.ui.modules.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppConstant.SIMPLE_SCAFFOLD_WITH_TOP_BAR


@Composable
fun SimpleScaffoldWithTopBarScreen() {
    SimpleScaffoldWithTopBarScreenSkeleton()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleScaffoldWithTopBarScreenSkeleton() {


    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding(),
        topBar = {
            TopAppBar(
                title = { Text(SIMPLE_SCAFFOLD_WITH_TOP_BAR) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            /* Icon click handler */
                        }
                    ) {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = stringResource(id = R.string.localized_description)
                        )
                    }
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                content = { Text(stringResource(R.string.extended_fab)) },
                onClick = { /* fab click handler */ }
            )
        },
        content = { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(count = 100) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(colors[it % colors.size])
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun SimpleScaffoldWithTopBarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        SimpleScaffoldWithTopBarScreenSkeleton()
    }
}

@Preview
@Composable
fun SimpleScaffoldWithTopBarScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        SimpleScaffoldWithTopBarScreenSkeleton()
    }
}

private val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)