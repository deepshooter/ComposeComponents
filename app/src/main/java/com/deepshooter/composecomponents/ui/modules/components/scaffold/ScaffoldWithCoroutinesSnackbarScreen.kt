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
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun ScaffoldWithCoroutinesSnackbarScreen() {
    ScaffoldWithCoroutinesSnackbarScreenSkeleton()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldWithCoroutinesSnackbarScreenSkeleton() {

    // Decouple snackbar host state from scaffold state for demo purposes
    // this state, channel and flow is for demo purposes to demonstrate business logic layer
    val snackBarHostState = remember { SnackbarHostState() }
    // we allow only one snackbar to be in the queue here, hence conflated
    val channel = remember { Channel<Int>(Channel.CONFLATED) }

    LaunchedEffect(channel) {
        channel.receiveAsFlow().collect { index ->
            val result = snackBarHostState.showSnackbar(
                message = "Snackbar # $index",
                actionLabel = "Action on $index"
            )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    /* action has been performed */
                }

                SnackbarResult.Dismissed -> {
                    /* dismissed, no action needed */
                }
            }
        }
    }
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding(),
        // attach snackbar host state to the scaffold
        snackbarHost = { SnackbarHost(snackBarHostState) },
        floatingActionButton = {
            var clickCount by remember { mutableIntStateOf(0) }
            ExtendedFloatingActionButton(
                content = { Text(stringResource(R.string.show_snackbar)) },
                onClick = {
                    // offset snackbar data to the business logic
                    channel.trySend(++clickCount)
                }
            )
        },
        content = {
            Text(
                stringResource(R.string.snackbar_demo),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }
    )
}

@Preview
@Composable
fun ScaffoldWithCoroutinesSnackbarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        ScaffoldWithCoroutinesSnackbarScreenSkeleton()
    }
}

@Preview
@Composable
fun ScaffoldWithCoroutinesSnackbarScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        ScaffoldWithCoroutinesSnackbarScreenSkeleton()
    }
}
