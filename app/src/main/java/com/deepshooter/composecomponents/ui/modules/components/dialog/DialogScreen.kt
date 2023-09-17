package com.deepshooter.composecomponents.ui.modules.components.dialog

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.DIALOG


@Composable
fun DialogScreen(
    goBack: () -> Unit
) {

    val openDefaultDialog = remember { mutableStateOf(false) }

    val openCustomDialog = remember { mutableStateOf(false) }

    DialogScreenSkeleton(
        goBack = goBack,
        showDefaultDialog = {
            openDefaultDialog.value = true
        },
        showCustomDialog = {
            openCustomDialog.value = true
        }
    )

    if (openDefaultDialog.value) {
        DefaultAlertDialog(
            state = openDefaultDialog
        )
    }

    if (openCustomDialog.value) {
        GeneralDialog(
            dialogState = openCustomDialog,
            title = stringResource(R.string.are_you_sure),
            message = stringResource(R.string.this_cannot_be_undone),
            positiveBtnText = stringResource(R.string.yes),
            onPositiveBtnClicked = {},
            negativeBtnText = stringResource(R.string.no),
            onNegativeBtnClicked = {}
        )
    }

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DialogScreenSkeleton(
    goBack: () -> Unit = {},
    showDefaultDialog: () -> Unit = {},
    showCustomDialog: () -> Unit = {}
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
                DIALOG,
                goBack = goBack
            )

            Divider()

            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 32.dp),
                onClick = {
                    showDefaultDialog()
                }
            ) {
                Text(stringResource(R.string.show_default_dialog))
            }

            AppComponent.MediumSpacer()

            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    showCustomDialog()
                }
            ) {
                Text(stringResource(R.string.show_custom_dialog))
            }

            AppComponent.BigSpacer()


        }
    }

}


@Composable
fun DefaultAlertDialog(
    state: MutableState<Boolean>
) {

    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onCloseRequest.
            state.value = false
        },
        title = {
            Text(text = stringResource(R.string.title))
        },
        text = {
            Text(
                stringResource(R.string.this_area_typically_contains_the_supportive_text_which_presents_the_details_regarding_the_dialog_s_purpose)
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    state.value = false
                }
            ) {
                Text(stringResource(R.string.confirm))
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    state.value = false
                }
            ) {
                Text(stringResource(R.string.dismiss))
            }
        }
    )
}

@Preview
@Composable
fun DialogScreenSkeletonPreview() {
    ComposeComponentsTheme {
        DialogScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DialogScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        DialogScreenSkeleton()
    }
}