package com.deepshooter.composecomponents.ui.modules.components.snackbar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.SNACKBAR


@Composable
fun SnackBarScreen(
    goBack: () -> Unit,
    navigate: (String) -> Unit
) {

    SnackBarScreenSkeleton(
        goBack = goBack,
        navigate = navigate
    )

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SnackBarScreenSkeleton(
    goBack: () -> Unit = {},
    navigate: (String) -> Unit = {}
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
                .verticalScroll(rememberScrollState())
        ) {
            AppComponent.Header(
                SNACKBAR,
                goBack = goBack
            )

            Divider()


        }
    }
}

@Composable
fun CustomSnackBarHost(state: SnackbarHostState) {
    SnackbarHost(state) { data ->
        CustomSnackBar(
            modifier = Modifier,
            snackBarData = data
        )
    }
}

@Composable
fun CustomSnackBar(
    snackBarData: SnackbarData,
    modifier: Modifier = Modifier,
    actionOnNewLine: Boolean = false,
    shape: Shape = MaterialTheme.shapes.small,
    backgroundColor: Color = SnackbarDefaults.contentColor,
    contentColor: Color = MaterialTheme.colorScheme.surface,
    actionColor: Color = SnackbarDefaults.actionColor
) {
    val actionLabel = snackBarData.visuals.actionLabel
    val actionComposable: (@Composable () -> Unit)? = if (actionLabel != null) {
        @Composable {
            TextButton(
                colors = ButtonDefaults.textButtonColors(contentColor = actionColor),
                onClick = { snackBarData.performAction() },
                content = { Text(actionLabel) }
            )
        }
    } else {
        null
    }
    Snackbar(
        modifier = modifier.padding(12.dp),
        content = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = snackBarData.visuals.message,
                textAlign = TextAlign.Center,
                color = contentColor
            )
        },
        action = actionComposable,
        actionOnNewLine = actionOnNewLine,
        shape = shape,
        containerColor = backgroundColor,
        contentColor = contentColor
    )
}


@Preview
@Composable
fun SnackBarScreenSkeletonPreview() {
    ComposeComponentsTheme {
        SnackBarScreenSkeleton()
    }
}

