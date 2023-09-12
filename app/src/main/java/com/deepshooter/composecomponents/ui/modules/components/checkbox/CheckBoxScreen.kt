package com.deepshooter.composecomponents.ui.modules.components.checkbox

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.CHECKBOX


private val ELEMENT_HEIGHT = 56.dp

@Composable
fun CheckBoxScreen(
    goBack: () -> Unit
) {
    CheckBoxScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckBoxScreenSkeleton(
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
                CHECKBOX,
                goBack = goBack
            )

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {

                AppComponent.SubHeader(stringResource(R.string.simple_check_box))

                val (state1, onStateChange1) = remember { mutableStateOf(false) }
                val (state2, onStateChange2) = remember { mutableStateOf(true) }

                GeneralCheckBox(
                    text = stringResource(R.string.do_what_you_love),
                    state = state1,
                    onStateChange = onStateChange1
                )
                GeneralCheckBox(
                    text = stringResource(R.string.love_what_you_do),
                    state = state2,
                    onStateChange = onStateChange2
                )

            }

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {

                AppComponent.SubHeader(stringResource(R.string.tri_state_checkbox))


                TriStateCheckboxSample()

                AppComponent.BigSpacer()

            }

        }

    }
}


@Composable
fun TriStateCheckboxSample() {
    Column {
        // define dependent checkboxes states
        val (state1, onStateChange1) = remember { mutableStateOf(true) }
        val (state2, onStateChange2) = remember { mutableStateOf(false) }

        // TriStateCheckbox state reflects state of dependent checkboxes
        val parentState = remember(state1, state2) {
            if (state1 && state2) {
                ToggleableState.On
            } else if (!state1 && !state2) {
                ToggleableState.Off
            } else {
                ToggleableState.Indeterminate
            }
        }
        // click on TriStateCheckbox can set state for dependent checkboxes
        val onParentClick = {
            val s = parentState != ToggleableState.On
            onStateChange1(s)
            onStateChange2(s)
        }

        GeneralTriStateCheckBox(
            text = stringResource(R.string.love_your_life),
            state = parentState,
            onClick = onParentClick
        )
        Column(Modifier.padding(32.dp, 0.dp, 0.dp, 0.dp)) {
            GeneralCheckBox(
                text = stringResource(R.string.love_what_you_do),
                state = state1,
                onStateChange = onStateChange1
            )
            GeneralCheckBox(
                text = stringResource(R.string.do_what_you_love),
                state = state2,
                onStateChange = onStateChange2
            )
        }
    }
}

@Composable
fun GeneralCheckBox(
    text: String,
    state: Boolean,
    onStateChange: (Boolean) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(ELEMENT_HEIGHT)
            .selectable(
                selected = state,
                onClick = { onStateChange(!state) },
                role = Role.RadioButton
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(state, null)
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun GeneralTriStateCheckBox(
    text: String,
    state: ToggleableState,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(ELEMENT_HEIGHT)
            .selectable(
                selected = state == ToggleableState.On,
                onClick = { onClick() },
                role = Role.Checkbox
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TriStateCheckbox(state, null)
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}


@Preview
@Composable
fun CheckBoxScreenSkeletonPreview() {
    ComposeComponentsTheme {
        CheckBoxScreenSkeleton()
    }
}