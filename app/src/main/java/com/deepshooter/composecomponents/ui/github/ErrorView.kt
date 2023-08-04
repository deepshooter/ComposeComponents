package com.deepshooter.composecomponents.ui.github

import android.content.res.Configuration
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme


@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    errorCode: Int,
    description: String?,
    failingUrl: String?,
    onRetry: () -> Unit = {}
) {

    Scaffold(modifier.fillMaxSize()) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp)
                    .fillMaxWidth(),
                painter = painterResource(
                    id = R.drawable.ic_undraw_location_search_modified
                ),
                contentDescription = null
            )

            Spacer(Modifier.height(32.dp))

            if (failingUrl != null) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                    text = buildAnnotatedString {
                        append("The webpage at ")

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("$failingUrl")
                        }

                        append(" could not be loaded.")
                    },
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }

            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = getMessage(errorCode, description),
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Button(
                modifier = Modifier.padding(top = 32.dp),
                onClick = { onRetry() }
            ) {
                Text("Try Again")
            }
        }
    }

}


private fun getMessage(
    errorCode: Int,
    description: String?
): String {
    return when (errorCode) {
        WebViewClient.ERROR_HOST_LOOKUP -> "The website not found! Maybe you are not connected to the Internet."
        WebViewClient.ERROR_TIMEOUT -> "Time out! Please try again."
        else -> description ?: "Please try again after some time."
    }
}

@Preview
@Composable
fun ErrorViewPreview() {
    ComposeComponentsTheme() {
        ErrorView(
            errorCode = WebViewClient.ERROR_HOST_LOOKUP,
            description = "Webpage not available",
            failingUrl = "https://github.com/deepshooter"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ErrorViewPreviewDark() {
    ComposeComponentsTheme {
        ErrorView(
            errorCode = WebViewClient.ERROR_HOST_LOOKUP,
            description = "Webpage not available",
            failingUrl = "https://github.com/deepshooter"
        )
    }
}