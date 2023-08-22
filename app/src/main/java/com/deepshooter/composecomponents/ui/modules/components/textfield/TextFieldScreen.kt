package com.deepshooter.composecomponents.ui.modules.components.textfield

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.platform.TextToolbar
import androidx.compose.ui.platform.TextToolbarStatus
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Gray100
import com.deepshooter.composecomponents.ui.theme.Gray50
import com.deepshooter.composecomponents.ui.theme.Gray800
import com.deepshooter.composecomponents.ui.theme.Gray900
import com.deepshooter.composecomponents.ui.theme.Red500
import com.deepshooter.composecomponents.ui.theme.Red900
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.TEXT_FIELD
import com.deepshooter.composecomponents.utils.UIThemeController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private val ELEMENT_HEIGHT = 48.dp


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

    val context = LocalContext.current

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

                //Official Samples
                AppComponent.SubHeader(stringResource(R.string.official_samples))
                SimpleTextFieldSample()
                AppComponent.MediumSpacer()
                SimpleOutlinedTextFieldSample()
                AppComponent.MediumSpacer()
                TextFieldWithIcons()
                AppComponent.MediumSpacer()
                TextFieldWithPlaceholder()
                AppComponent.MediumSpacer()
                TextFieldWithErrorState()
                AppComponent.MediumSpacer()
                TextFieldWithHelperMessage()
                AppComponent.MediumSpacer()
                PasswordTextField()
                AppComponent.MediumSpacer()
                TextFieldSample()
                AppComponent.MediumSpacer()
                OutlinedTextFieldSample()
                AppComponent.MediumSpacer()
                TextFieldWithHideKeyboardOnImeAction()
                AppComponent.MediumSpacer()

            }

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {

                //Cut-Copy-Paste Disabled
                AppComponent.SubHeader(stringResource(R.string.cut_copy_paste_disabled))
                TextFieldWithCutCopyPasteDisabled()
                AppComponent.MediumSpacer()

            }

            Divider()

            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {

                //Custom Type One
                AppComponent.SubHeader(stringResource(R.string.custom_type_one))

                TextInputFieldOne(
                    textFieldValue = remember { mutableStateOf(TextFieldValue()) },
                    placeholder = stringResource(R.string.i_am_a_placeholder),
                    keyboardType = KeyboardType.Text
                )

                AppComponent.MediumSpacer()

                TextInputFieldOne(
                    textFieldValue = remember { mutableStateOf(TextFieldValue()) },
                    placeholder = stringResource(R.string.i_am_a_placeholder),
                    isError = true
                )

                AppComponent.MediumSpacer()

                TextInputFieldOne(
                    textFieldValue = remember {
                        mutableStateOf(TextFieldValue(context.getString(R.string.lorem_ipsum_dolor_sit_amet)))
                    },
                    placeholder = "I am  a placeholder"
                )

                AppComponent.MediumSpacer()

                TextInputFieldOne(
                    textFieldValue = remember {
                        mutableStateOf(TextFieldValue(context.getString(R.string.lorem_ipsum_dolor_sit_amet)))
                    },
                    isError = true
                )


                AppComponent.MediumSpacer()

                TextInputFieldOne(
                    modifier = Modifier
                        .height(128.dp),
                    textFieldValue = remember { mutableStateOf(TextFieldValue()) },
                    placeholder = stringResource(R.string.i_am_a_multi_line_placeholder_here_is_another_line),
                    keyboardType = KeyboardType.Text,
                    singleLine = false
                )


                AppComponent.MediumSpacer()

                TextInputFieldOne(
                    modifier = Modifier
                        .height(128.dp),
                    textFieldValue = remember {
                        mutableStateOf(
                            TextFieldValue(context.getString(R.string.random_text))
                        )
                    },
                    placeholder = stringResource(R.string.i_am_a_multi_line_placeholder_here_is_another_line),
                    keyboardType = KeyboardType.Text,
                    singleLine = false
                )


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

@Composable
fun TextFieldWithPlaceholder() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text("Email") },
        placeholder = { Text("example@gmail.com") }
    )
}

@Composable
fun TextFieldWithErrorState() {
    val context = LocalContext.current
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }

    fun validate(text: String) {
        isError = text.count() < 5
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
            isError = false
        },
        singleLine = true,
        label = { Text(if (isError) "Email*" else "Email") },
        isError = isError,
        keyboardActions = KeyboardActions { validate(text) },
        modifier = Modifier
            .fillMaxWidth()
            .semantics {
                // Provide localized description of the error
                if (isError) {
                    Toast
                        .makeText(context, "Email format is invalid.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    )
}

@Composable
fun TextFieldWithHelperMessage() {
    var text by rememberSaveable { mutableStateOf("") }

    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") }
        )
        Text(
            text = "Helper message",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                // Please provide localized description for accessibility services
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}

@Composable
fun TextFieldSample() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("example", TextRange(0, 7)))
    }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Composable
fun OutlinedTextFieldSample() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("example", TextRange(0, 7)))
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldWithHideKeyboardOnImeAction() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )
    )
}

object EmptyTextToolbar : TextToolbar {
    override val status: TextToolbarStatus = TextToolbarStatus.Hidden
    override fun hide() {}
    override fun showMenu(
        rect: Rect,
        onCopyRequested: (() -> Unit)?,
        onPasteRequested: (() -> Unit)?,
        onCutRequested: (() -> Unit)?,
        onSelectAllRequested: (() -> Unit)?
    ) {
    }
}

@Composable
fun TextFieldWithCutCopyPasteDisabled() {
    var textValue by remember { mutableStateOf(TextFieldValue()) }

    CompositionLocalProvider(LocalTextToolbar provides EmptyTextToolbar) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textValue,
            onValueChange = { newValue ->
                textValue = if (newValue.selection.length > 0) {
                    newValue.copy(selection = textValue.selection)
                } else {
                    newValue
                }
            }
        )
    }
}


@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun TextInputFieldOne(
    modifier: Modifier = Modifier,
    textFieldValue: MutableState<TextFieldValue>,
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    imeAction: ImeAction? = null,
    keyboardActions: KeyboardActions? = null,
    fontSize: TextUnit = 16.sp,
    height: Dp = ELEMENT_HEIGHT,
    isError: Boolean = false,
    onValueChange: (TextFieldValue) -> Unit = {}
) {
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val interactionSource = remember { MutableInteractionSource() }
    val interactionSourceState = interactionSource.collectIsFocusedAsState()
    val scope = rememberCoroutineScope()
    val isImeVisible = WindowInsets.isImeVisible

    // Bring the composable into view (visible to user).
    LaunchedEffect(isImeVisible, interactionSourceState.value) {
        if (isImeVisible && interactionSourceState.value) {
            scope.launch {
                delay(300)
                bringIntoViewRequester.bringIntoView()
            }
        }
    }

    val isDark by UIThemeController.isDarkMode.collectAsState()


    BasicTextField(
        value = textFieldValue.value,
        singleLine = singleLine,
        textStyle = TextStyle(
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontSize = fontSize,
            color = if (isDark) Gray50 else Gray900
        ),
        onValueChange = {
            textFieldValue.value = it

            onValueChange(it)
        },
        keyboardActions = keyboardActions ?: KeyboardActions(
            onDone = { focusManager.clearFocus() },
            onNext = { focusManager.moveFocus(FocusDirection.Down) },
            onSearch = { focusManager.clearFocus() }
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction ?: if (singleLine) ImeAction.Done else ImeAction.Default
        ),
        interactionSource = interactionSource,
        modifier = modifier
            .bringIntoViewRequester(bringIntoViewRequester)
            .fillMaxWidth(),
        readOnly = readOnly,
        decorationBox = { innerTextField ->
            Box(
                Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(
                        if (isError) {
                            if (isDark) Red900.copy(.95f) else Red500.copy(.1f)
                        } else {
                            if (isDark) Gray800 else Gray100
                        }
                    )
                    .height(height)
                    .padding(horizontal = 12.dp),
                contentAlignment = if (singleLine) Alignment.CenterStart else Alignment.TopStart
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            top = if (singleLine) 0.dp else 12.5.dp,
                            bottom = if (singleLine) 2.5.dp else 12.5.dp
                        )
                ) {
                    innerTextField()

                    if (textFieldValue.value.text.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = if (isDark) Gray50.copy(.35f) else Gray900.copy(.35f),
                            fontSize = fontSize,
                            maxLines = if (singleLine) 1 else Int.MAX_VALUE,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
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