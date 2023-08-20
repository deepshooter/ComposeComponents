package com.deepshooter.composecomponents.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme

object AppComponent {

    @Composable
    fun Header(
        text: String,
        modifier: Modifier = Modifier,
        goBack: () -> Unit
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = goBack
            ) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = "Go Back"
                )
            }

            Text(
                modifier = modifier
                    .padding(
                        start = 0.dp,
                        top = 32.dp,
                        end = 48.dp,
                        bottom = 32.dp
                    )
                    .fillMaxWidth(),
                text = text,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }

    @Composable
    fun SubHeader(
        text: String,
        modifier: Modifier = Modifier
    ) {
        Text(
            modifier = modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .fillMaxWidth(),
            text = text,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun MediumSpacer(
        modifier: Modifier = Modifier
    ) {
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(16.dp)
        )
    }

    @Composable
    fun BigSpacer(
        modifier: Modifier = Modifier
    ) {
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(32.dp)
        )
    }

}

@Preview
@Composable
fun AppComponentPreview() {
    ComposeComponentsTheme {
        Scaffold { innerPadding ->
            Column(Modifier.padding(innerPadding)) {

                AppComponent.Header(text = "Header") {}

                Divider()

                AppComponent.SubHeader(text = "SubHeader")

                Divider()

                AppComponent.MediumSpacer()

                Divider()

                AppComponent.BigSpacer()
            }
        }
    }
}