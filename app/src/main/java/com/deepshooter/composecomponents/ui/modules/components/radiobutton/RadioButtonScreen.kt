package com.deepshooter.composecomponents.ui.modules.components.radiobutton

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
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.RADIO_BUTTON

private val ELEMENT_HEIGHT = 56.dp


@Composable
fun RadioButtonScreen(
    goBack: () -> Unit
) {
    RadioButtonScreenSkeleton(
        goBack = goBack
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RadioButtonScreenSkeleton(
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
                RADIO_BUTTON,
                goBack = goBack
            )

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppComponent.SubHeader(stringResource(R.string.simple_radio_button))

                RadioGroupSample()
            }

            AppComponent.BigSpacer()

        }
    }
}

@Composable
fun RadioGroupSample() {
    // The first item of Pair is the caption and the second item is the value
    // that can be sent to the server or used for other logic.
    val radioOptions = listOf("Happiness" to 1, "Money" to 2, "Both" to 3)
    val (selectedOption, onOptionSelected) = remember { mutableIntStateOf(radioOptions[0].second) }

    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            GeneralRadioButton(
                text = text.first,
                value = text.second,
                selectedOption = selectedOption,
                onOptionSelected = onOptionSelected
            )
        }
    }
}

@Composable
fun <T> GeneralRadioButton(
    modifier: Modifier = Modifier,
    text: String,
    value: T,
    selectedOption: T,
    onOptionSelected: (T) -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(ELEMENT_HEIGHT)
            .selectable(
                selected = (value == selectedOption),
                onClick = { onOptionSelected(value) },
                role = Role.RadioButton
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = (value == selectedOption),
            onClick = null // null recommended for accessibility with screen readers
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}


@Preview
@Composable
fun RadioButtonScreenSkeletonPreview() {
    ComposeComponentsTheme {
        RadioButtonScreenSkeleton()
    }
}
