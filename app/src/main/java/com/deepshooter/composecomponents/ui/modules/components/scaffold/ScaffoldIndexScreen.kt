package com.deepshooter.composecomponents.ui.modules.components.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.SCAFFOLD


@Composable
fun ScaffoldIndexScreen(
    goBack: () -> Unit,
    navigate: (ComponentsScreen) -> Unit
) {
    ScaffoldIndexSkeleton(
        goBack = goBack,
        navigate = navigate
    )
}

@Composable
fun ScaffoldIndexSkeleton(
    goBack: () -> Unit = {},
    navigate: (ComponentsScreen) -> Unit = {}
) {

    Scaffold(
        Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding()
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            AppComponent.Header(
                SCAFFOLD,
                goBack = goBack
            )


        }
    }
}

@Preview
@Composable
fun ScaffoldIndexSkeletonPreview() {
    ComposeComponentsTheme {
        ScaffoldIndexSkeleton()
    }
}