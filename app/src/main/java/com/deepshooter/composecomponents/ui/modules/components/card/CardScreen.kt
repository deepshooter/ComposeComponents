package com.deepshooter.composecomponents.ui.modules.components.card

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.CARD


@Composable
fun CardScreen(
    goBack: () -> Unit
) {
    CardScreenSkeleton(
        goBack = goBack
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CardScreenSkeleton(
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
                CARD,
                goBack = goBack
            )

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {
                AppComponent.SubHeader(stringResource(R.string.simple_card))

                //Card 1
                Card(
                    Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(16.dp, 8.dp),
                        text = stringResource(R.string.hello_world) + stringResource(R.string.how_are_you)
                    )
                }

                AppComponent.MediumSpacer()

                //Card 2
                var count by remember { mutableIntStateOf(0) }

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = { count++ }
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.you_clicked_this_card),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "$count time${if (count > 1) stringResource(R.string.s) else ""}",
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                    }
                }

                AppComponent.BigSpacer()

            }
        }
    }
}

@Preview
@Composable
fun CardScreenSkeletonPreview() {
    ComposeComponentsTheme {
        CardScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CardScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        CardScreenSkeleton()
    }
}
