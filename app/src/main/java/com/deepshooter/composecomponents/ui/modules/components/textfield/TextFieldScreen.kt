package com.deepshooter.composecomponents.ui.modules.components.textfield

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.TEXT_FIELD


@Composable
fun TextFieldScreen(
    goBack: () -> Unit
) {
    TextFieldScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TextFieldScreenSkeleton(
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
                TEXT_FIELD,
                goBack = goBack
            )

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {

                AppComponent.SubHeader("Official Samples")
                SimpleTextFieldSample()
                AppComponent.MediumSpacer()
                SimpleOutlinedTextFieldSample()
                AppComponent.MediumSpacer()
                TextFieldWithIcons()
                AppComponent.MediumSpacer()

            }


        }
    }
}


@Composable
fun SimpleTextFieldSample() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        singleLine = true
    )
}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Composable
fun TextFieldWithIcons() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        placeholder = { Text("Placeholder") },
        leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Localized description") },
        trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Localized description") }
    )
}

@Preview
@Composable
fun TextFieldScreenSkeletonPreview() {
    ComposeComponentsTheme {
        TextFieldScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextFieldScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        TextFieldScreenSkeleton()
    }
}