package com.deepshooter.composecomponents.ui.modules.components.progressindicator

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.PROGRESS_INDICATOR


@Composable
fun ProgressIndicatorScreen(
    goBack: () -> Unit
) {

    ProgressIndicatorScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProgressIndicatorScreenSkeleton(
    goBack: () -> Unit = {}
) {

    var showLoading by remember { mutableStateOf(false) }


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
                PROGRESS_INDICATOR,
                goBack = goBack
            )

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AppComponent.SubHeader(stringResource(R.string.linear_progress_indicator))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LinearProgressIndicator()
                }

                AppComponent.MediumSpacer()


                var progress1 by remember { mutableFloatStateOf(0.1f) }
                val animatedProgress1 by animateFloatAsState(
                    targetValue = progress1,
                    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    LinearProgressIndicator(progress = animatedProgress1)

                    Spacer(Modifier.requiredHeight(32.dp))

                    OutlinedButton(
                        onClick = {
                            if (progress1 < 1f) progress1 += 0.1f
                        }
                    ) {
                        Text(stringResource(R.string.increase))
                    }
                }

                AppComponent.MediumSpacer()

            }

            Divider()



        }
    }
}


@Preview
@Composable
fun ProgressIndicatorScreenSkeletonPreview() {
    ComposeComponentsTheme {
        ProgressIndicatorScreenSkeleton()
    }
}

@Preview
@Composable
fun ProgressIndicatorScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        ProgressIndicatorScreenSkeleton()
    }
}