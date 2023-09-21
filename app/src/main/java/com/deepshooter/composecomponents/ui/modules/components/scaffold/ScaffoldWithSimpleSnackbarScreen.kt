package com.deepshooter.composecomponents.ui.modules.components.scaffold

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import kotlinx.coroutines.launch


@Composable
fun ScaffoldWithSimpleSnackbarScreen() {
    ScaffoldWithSimpleSnackbarScreenSkeleton()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldWithSimpleSnackbarScreenSkeleton() {

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding(),
        snackbarHost = { SnackbarHost(snackBarHostState) },
        floatingActionButton = {
            var clickCount by remember { mutableIntStateOf(0) }
            ExtendedFloatingActionButton(
                content = { Text(stringResource(R.string.show_snackbar)) },
                onClick = {
                    // Show snackbar as a suspend function
                    scope.launch {
                        snackBarHostState.showSnackbar("Snackbar # ${++clickCount}")
                    }
                }
            )
        },
        content = {
            Text(
                text = stringResource(R.string.body_content),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }
    )

}

@Preview
@Composable
fun ScaffoldWithSimpleSnackbarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        ScaffoldWithSimpleSnackbarScreenSkeleton()
    }
}

@Preview
@Composable
fun ScaffoldWithSimpleSnackbarScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        ScaffoldWithSimpleSnackbarScreenSkeleton()
    }
}
