package com.deepshooter.composecomponents.ui.modules.components.button

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.BUTTON


@Composable
fun ButtonScreen(
    goBack: () -> Unit
) {
    ButtonScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ButtonScreenSkeleton(
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
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AppComponent.Header(
                BUTTON,
                goBack = goBack
            )

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AppComponent.SubHeader(stringResource(id = R.string.official_samples))

                //Simple Button
                Button(onClick = { /* Do something! */ }) {
                    Text(stringResource(R.string.button))
                }

                AppComponent.MediumSpacer()

                //Outlined Button
                OutlinedButton(onClick = { /* Do something! */ }) {
                    Text(stringResource(R.string.outlined_button))
                }

                AppComponent.MediumSpacer()

                //Text Button
                TextButton(onClick = { /* Do something! */ }) {
                    Text(stringResource(R.string.text_button))
                }

                AppComponent.MediumSpacer()

            }

        }
    }

}


@Preview
@Composable
fun ButtonScreenSkeletonPreview() {
    ComposeComponentsTheme() {
        ButtonScreenSkeleton()
    }
}