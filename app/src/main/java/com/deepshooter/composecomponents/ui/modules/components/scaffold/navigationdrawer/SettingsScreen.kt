package com.deepshooter.composecomponents.ui.modules.components.scaffold.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.Blue500

@Composable
fun SettingsScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Blue500)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.settings_screen),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(R.string.this_place_will_soon_have_a_design),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Preview
@Composable
fun SettingScreenPreview() {
    SettingsScreen()
}