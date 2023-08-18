package com.deepshooter.composecomponents.ui.modules.components.index

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent.Header
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_TITLE

@Composable
fun ComponentsIndexScreen(
    goBack: () -> Unit,
    navigate: (ComponentsScreen) -> Unit
) {
    ComponentsIndexSkeleton(
        goBack = goBack,
        navigate = navigate
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ComponentsIndexSkeleton(
    goBack: () -> Unit = {},
    navigate: (ComponentsScreen) -> Unit = {}
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

            Header(
                COMPONENTS_TITLE,
                goBack = goBack
            )

            Divider()

            LazyColumn(Modifier.fillMaxSize()) {
                itemsIndexed(Components.componentsList) { index, item ->

                    if (index != 0) {
                        Divider(Modifier.padding(16.dp, 0.dp))
                    }

                    Text(
                        modifier = Modifier
                            .clickable {
                                navigate(item.route)
                            }
                            .padding(
                                start = 16.dp,
                                top = 8.dp,
                                end = 16.dp,
                                bottom = 8.dp
                            )
                            .fillMaxWidth(),
                        text = item.name
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun CompositionIndexSkeletonPreview() {
    ComposeComponentsTheme {
        ComponentsIndexSkeleton()
    }
}