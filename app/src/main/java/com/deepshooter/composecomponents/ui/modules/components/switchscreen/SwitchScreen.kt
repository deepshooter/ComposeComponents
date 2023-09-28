package com.deepshooter.composecomponents.ui.modules.components.switchscreen

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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.SWITCH


private val ELEMENT_HEIGHT = 56.dp

@Composable
fun SwitchScreen(
    goBack: () -> Unit
) {
    SwitchScreenSkeleton(
        goBack = goBack
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SwitchScreenSkeleton(
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
                SWITCH,
                goBack = goBack
            )

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {

                AppComponent.SubHeader(stringResource(R.string.start_switch))

                val (state1, onStateChange1) = remember { mutableStateOf(true) }
                val (state2, onStateChange2) = remember { mutableStateOf(false) }

                GeneralStartSwitch(
                    text = stringResource(id = R.string.do_what_you_love),
                    state = state1,
                    onStateChange = onStateChange1
                )

                GeneralStartSwitch(
                    text = stringResource(id = R.string.love_what_you_do),
                    state = state2,
                    onStateChange = onStateChange2
                )

            }

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {

                AppComponent.SubHeader(stringResource(R.string.end_switch))

                val (state3, onStateChange3) = remember { mutableStateOf(false) }
                val (state4, onStateChange4) = remember { mutableStateOf(true) }

                GeneralEndSwitch(
                    text = stringResource(id = R.string.do_what_you_love),
                    state = state3,
                    onStateChange = onStateChange3
                )

                GeneralEndSwitch(
                    text = stringResource(id = R.string.love_what_you_do),
                    state = state4,
                    onStateChange = onStateChange4
                )

            }

            AppComponent.BigSpacer()

        }
    }
}

@Composable
fun GeneralStartSwitch(
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
                role = Role.Switch
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = state,
            onCheckedChange = null
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun GeneralEndSwitch(
    text: String,
    state: Boolean,
    onStateChange: (Boolean) -> Unit,
    fontWeight: FontWeight? = MaterialTheme.typography.bodyMedium.fontWeight
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(ELEMENT_HEIGHT)
            .selectable(
                selected = state,
                onClick = { onStateChange(!state) },
                role = Role.Switch
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = fontWeight
            ),
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(1f)
        )
        Switch(
            checked = state,
            onCheckedChange = null
        )
    }
}


@Preview
@Composable
fun SwitchScreenSkeletonPreview() {
    ComposeComponentsTheme {
        SwitchScreenSkeleton()
    }
}
