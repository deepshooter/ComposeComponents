package com.deepshooter.composecomponents.ui.modules.components.scaffold

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
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
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import kotlinx.coroutines.launch

@Composable
fun ScaffoldWithCustomSnackbarScreen() {
    ScaffoldWithCustomSnackbarScreenSkeleton()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldWithCustomSnackbarScreenSkeleton() {

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding(),
        snackbarHost = {
            // Reuse default SnackbarHost to have default animation and timing handling
            SnackbarHost(snackBarHostState) { data ->
                // custom snackbar with the custom border
                Snackbar(
                    modifier = Modifier.border(2.dp, MaterialTheme.colorScheme.secondary),
                    snackbarData = data
                )
            }
        },
        floatingActionButton = {
            var clickCount by remember { mutableIntStateOf(0) }
            ExtendedFloatingActionButton(
                content = { Text(stringResource(R.string.show_snackbar)) },
                onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar("Snackbar # ${++clickCount}")
                    }
                }
            )
        },
        content = {
            Text(
                text = stringResource(R.string.custom_snackbar_demo),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }
    )

}

@Preview
@Composable
fun ScaffoldWithCustomSnackbarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        ScaffoldWithCustomSnackbarScreenSkeleton()
    }
}

@Preview
@Composable
fun ScaffoldWithCustomSnackbarScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        ScaffoldWithCustomSnackbarScreenSkeleton()
    }
}