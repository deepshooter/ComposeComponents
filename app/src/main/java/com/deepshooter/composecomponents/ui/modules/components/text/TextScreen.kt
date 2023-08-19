package com.deepshooter.composecomponents.ui.modules.components.text

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.ui.theme.Blue500
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Purple700
import com.deepshooter.composecomponents.ui.theme.Yellow700
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.TEXT


@Composable
fun TextScreen(
    goBack: () -> Unit
) {
    TextScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TextScreenSkeleton(
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
                TEXT,
                goBack = goBack
            )

            Divider()

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                AppComponent.MediumSpacer()
                NormalText()
                AppComponent.MediumSpacer()
                AnnotatedText()
                AppComponent.MediumSpacer()
                SecondAnnotatedText()
                AppComponent.MediumSpacer()
                ParagraphStyleText()
                AppComponent.MediumSpacer()
                SelectedText()
                AppComponent.MediumSpacer()
                SelectedAndDisableText()
                AppComponent.MediumSpacer()
                ClickableText()
                AppComponent.MediumSpacer()
                SecondClickableText()
                AppComponent.BigSpacer()

            }
        }
    }
}


@Composable
fun NormalText() {
    Text(
        text = "This is a normal text.",
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun AnnotatedText() {
    Text(
        buildAnnotatedString {
            append("This is an ")

            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            ) {
                append("annotated")
            }

            append(" text.")
        }
    )
}

@Composable
fun SecondAnnotatedText() {
    val annotatedString = with(AnnotatedString.Builder("Hello")) {
        // push green text style so that any appended text will be green
        pushStyle(SpanStyle(color = MaterialTheme.colorScheme.primary))
        // append new text, this text will be rendered as green
        append(" World")
        // pop the green style
        pop()
        // append a string without style
        append("!")
        // then style the last added word as red, exclamation mark will be red
        addStyle(
            SpanStyle(color = MaterialTheme.colorScheme.secondary),
            "Hello World".length,
            this.length
        )

        toAnnotatedString()
    }
    Text(annotatedString)
}


@Composable
fun ParagraphStyleText() {
    val text =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua.\nUt enim ad minim veniam, quis " +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."

    val paragraphStyle1 = ParagraphStyle(
        textIndent = TextIndent(firstLine = 14.sp)
    )
    val paragraphStyle2 = ParagraphStyle(
        lineHeight = 30.sp
    )

    Text(
        text = buildAnnotatedString {
            append(text)
            addStyle(paragraphStyle1, 0, text.indexOf('\n') + 1)
            addStyle(paragraphStyle2, text.indexOf('\n') + 1, text.length)
        },
        color = Purple700,
    )
}


@Composable
fun SelectedText() {
    SelectionContainer {
        Text("This text is selectable")
    }
}

@Composable
fun SelectedAndDisableText() {
    SelectionContainer {
        Column {
            Text("This text is selectable", color = Blue500)
            Text("This one too", color = Blue500)
            Text("This one as well", color = Blue500)
            DisableSelection {
                Text("But not this one", color = Yellow700)
                Text("Neither this one", color = Yellow700)
            }
            Text("But again, you can select this one", color = Blue500)
            Text("And this one too", color = Blue500)
        }
    }
}

@Composable
fun ClickableText() {
    val context = LocalContext.current
    ClickableText(
        text = AnnotatedString("Click Me"),
        style = MaterialTheme.typography.headlineSmall.copy(
            color = MaterialTheme.colorScheme.onBackground,
            fontStyle = FontStyle.Italic
        ),
        onClick = { offset ->
            Toast.makeText(context, "$offset -th character is clicked.", Toast.LENGTH_LONG).show()
        }
    )
}

@Composable
fun SecondClickableText() {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append("Click ")

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("here")
        }

        pop()
    }

    ClickableText(
        text = annotatedText,
        style = MaterialTheme.typography.headlineSmall.copy(color = MaterialTheme.colorScheme.onBackground),
        onClick = { offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    // If yes, we log its value
                    Toast.makeText(context, "Clicked URL: " + annotation.item, Toast.LENGTH_LONG)
                        .show()
                }
        }
    )
}


@Preview
@Composable
fun TextScreenSkeletonPreview() {
    ComposeComponentsTheme {
        TextScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        TextScreenSkeleton()
    }
}