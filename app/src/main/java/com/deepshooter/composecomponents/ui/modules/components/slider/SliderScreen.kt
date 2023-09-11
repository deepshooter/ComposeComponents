package com.deepshooter.composecomponents.ui.modules.components.slider

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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.SLIDER


@Composable
fun SliderScreen(
    goBack: () -> Unit
) {
    SliderScreenSkeleton(
        goBack = goBack
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SliderScreenSkeleton(
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
                .verticalScroll(rememberScrollState())
        ) {
            AppComponent.Header(
                SLIDER,
                goBack = goBack
            )

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {

                AppComponent.MediumSpacer()

                var sliderPosition by remember { mutableFloatStateOf(0f) }
                Text(text = String.format(stringResource(R.string._2f), sliderPosition))
                Slider(value = sliderPosition, onValueChange = { sliderPosition = it })

                AppComponent.MediumSpacer()

                var stepSliderPosition by remember { mutableFloatStateOf(0f) }
                Text(text = String.format(stringResource(R.string._2f), stepSliderPosition))
                Slider(
                    value = stepSliderPosition,
                    onValueChange = { stepSliderPosition = it },
                    valueRange = 0f..100f,
                    onValueChangeFinished = {
                        // launch some business logic update with the state you hold
                        // viewModel.updateSelectedSliderValue(sliderPosition)
                    },
                    steps = 5,
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = MaterialTheme.colorScheme.secondary
                    )
                )

            }

            AppComponent.BigSpacer()



        }
    }
}


@Preview
@Composable
fun SliderScreenSkeletonPreview() {
    ComposeComponentsTheme {
        SliderScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SliderScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        SliderScreenSkeleton()
    }
}