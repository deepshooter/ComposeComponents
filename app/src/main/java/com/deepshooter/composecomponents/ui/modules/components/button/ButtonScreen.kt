package com.deepshooter.composecomponents.ui.modules.components.button

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Green900
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

                //Button With Icon and Text
                Button(onClick = { /* Do something! */ }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(
                        stringResource(R.string.like),
                        color = Color.White
                    )
                }

                AppComponent.MediumSpacer()

                //IconButton
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = stringResource(R.string.localized_description)
                    )
                }

                AppComponent.MediumSpacer()


                //IconToggleButton
                var checked by remember { mutableStateOf(false) }

                IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                    val tint by animateColorAsState(
                        if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5)
                    )
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = stringResource(R.string.localized_description),
                        tint = tint
                    )
                }

                AppComponent.MediumSpacer()

            }

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AppComponent.SubHeader(stringResource(R.string.solid_buttons))

                AppComponent.MediumSpacer()

                SolidButton(
                    text = stringResource(R.string.like),
                    onClick = {}
                )


                AppComponent.MediumSpacer()

                SolidButton(
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                SolidButton(
                    text = stringResource(R.string.like),
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                SolidButton(
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

            }

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AppComponent.SubHeader(stringResource(R.string.solid_wide_buttons))

                AppComponent.MediumSpacer()

                SolidWideButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.like),
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                SolidWideButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                SolidWideButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.like),
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                SolidWideButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

            }

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AppComponent.SubHeader(stringResource(R.string.gradient_buttons))

                AppComponent.MediumSpacer()

                GradientButton(
                    text = stringResource(R.string.like),
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                GradientButton(
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                GradientButton(
                    text = stringResource(R.string.like),
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                GradientButton(
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

            }

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AppComponent.SubHeader(stringResource(R.string.gradient_wide_buttons))

                AppComponent.MediumSpacer()

                GradientWideButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.like),
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                GradientWideButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                GradientWideButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.like),
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                GradientWideButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()
            }

            Divider()

            Column(
                Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppComponent.SubHeader(stringResource(R.string.bordered_buttons))

                AppComponent.MediumSpacer()

                BorderedButton(
                    text = stringResource(R.string.like),
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                BorderedButton(
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                BorderedButton(
                    text = stringResource(R.string.like),
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

                BorderedButton(
                    text = stringResource(R.string.like),
                    startIcon = R.drawable.ic_danger_circle,
                    endIcon = R.drawable.ic_danger_circle,
                    onClick = {}
                )

                AppComponent.MediumSpacer()

            }
        }
    }
}


@Composable
fun SolidButton(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
    height: Dp = ButtonDefaults.MinHeight,
    fontSize: TextUnit = 16.sp,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = MaterialTheme.shapes.medium,
    onClick: () -> Unit
) {
    val currentFocus = LocalFocusManager.current

    Button(
        modifier = modifier.height(height),
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        onClick = {
            currentFocus.clearFocus()

            onClick()
        }
    ) {
        if (startIcon != null) {
            Icon(
                painterResource(id = startIcon),
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }

        Text(
            text,
            style = MaterialTheme.typography.displayMedium,
            color = Color.White,
            fontSize = fontSize
        )

        if (endIcon != null) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                painterResource(id = endIcon),
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
            )
        }
    }
}

@Composable
fun SolidWideButton(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
    height: Dp = ButtonDefaults.MinHeight,
    fontSize: TextUnit = 16.sp,
    horizontalPadding: Dp = ButtonDefaults.IconSpacing,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = MaterialTheme.shapes.medium,
    onClick: () -> Unit
) {
    val currentFocus = LocalFocusManager.current

    Button(
        modifier = modifier
            .height(height),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = Color.White
        ),
        onClick = {
            currentFocus.clearFocus()

            onClick()
        }
    ) {
        if (startIcon != null) {
            Icon(
                modifier = Modifier.size(ButtonDefaults.IconSize),
                painter = painterResource(id = startIcon),
                contentDescription = text
            )
            Spacer(Modifier.size(horizontalPadding))
        }

        Text(
            modifier = Modifier
                .padding(
                    start = if (startIcon != null) 0.dp else ButtonDefaults.IconSize + horizontalPadding,
                    end = if (endIcon != null) 0.dp else ButtonDefaults.IconSize + horizontalPadding
                )
                .weight(1f),
            text = text,
            fontSize = fontSize,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        if (endIcon != null) {
            Spacer(Modifier.size(horizontalPadding))
            Icon(
                modifier = Modifier.size(ButtonDefaults.IconSize),
                painter = painterResource(id = endIcon),
                contentDescription = text
            )
        }
    }
}

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
    height: Dp = ButtonDefaults.MinHeight,
    fontSize: TextUnit = 16.sp,
    backgroundGradient: Brush = defaultButtonBackgroundBrush(),
    shape: Shape = MaterialTheme.shapes.medium,
    onClick: () -> Unit
) {
    val currentFocus = LocalFocusManager.current

    TextButton(
        modifier = modifier
            .height(height)
            .background(
                brush = backgroundGradient,
                shape = shape
            ),
        shape = shape,
        onClick = {
            currentFocus.clearFocus()

            onClick()
        }
    ) {
        if (startIcon != null) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                painterResource(id = startIcon),
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
            )
        }

        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

        Text(
            text,
            style = MaterialTheme.typography.displayMedium,
            color = Color.White,
            fontSize = fontSize
        )

        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

        if (endIcon != null) {
            Icon(
                painterResource(id = endIcon),
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }
    }
}

@Composable
fun GradientWideButton(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
    height: Dp = ButtonDefaults.MinHeight,
    fontSize: TextUnit = 16.sp,
    horizontalPadding: Dp = ButtonDefaults.IconSpacing,
    backgroundGradient: Brush = defaultButtonBackgroundBrush(),
    shape: Shape = MaterialTheme.shapes.medium,
    onClick: () -> Unit
) {
    val currentFocus = LocalFocusManager.current

    TextButton(
        modifier = modifier
            .height(height)
            .background(
                brush = backgroundGradient,
                shape = shape
            ),
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.White
        ),
        shape = shape,
        onClick = {
            currentFocus.clearFocus()

            onClick()
        }
    ) {
        if (startIcon != null) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                modifier = Modifier.size(ButtonDefaults.IconSize),
                painter = painterResource(id = startIcon),
                contentDescription = text,
                tint = Color.White
            )
        }

        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

        Text(
            modifier = Modifier
                .padding(
                    start = if (startIcon != null) 0.dp else ButtonDefaults.IconSize + horizontalPadding,
                    end = if (endIcon != null) 0.dp else ButtonDefaults.IconSize + horizontalPadding
                )
                .weight(1f),
            text = text,
            fontSize = fontSize,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

        if (endIcon != null) {
            Icon(
                modifier = Modifier.size(ButtonDefaults.IconSize),
                painter = painterResource(id = endIcon),
                contentDescription = text,
                tint = Color.White
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }
    }
}

@Composable
fun BorderedButton(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
    height: Dp = ButtonDefaults.MinHeight,
    fontSize: TextUnit = 16.sp,
    borderGradient: Brush = defaultButtonBackgroundBrush(.3f),
    shape: Shape = MaterialTheme.shapes.medium,
    onClick: () -> Unit
) {
    val currentFocus = LocalFocusManager.current

    OutlinedButton(
        modifier = modifier
            .height(height),
        border = BorderStroke(
            width = 2.dp,
            brush = borderGradient
        ),
        shape = shape,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent
        ),
        onClick = {
            currentFocus.clearFocus()

            onClick()
        }
    ) {
        if (startIcon != null) {
            Icon(
                painterResource(id = startIcon),
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }

        Text(
            text,
            style = MaterialTheme.typography.displayMedium,
            fontSize = fontSize
        )

        if (endIcon != null) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                painterResource(id = endIcon),
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}


@Composable
fun defaultButtonBackgroundBrush(
    alpha: Float = 1f
) = Brush.verticalGradient(
    0.0f to MaterialTheme.colorScheme.primary.copy(alpha),
    1.0f to Green900.copy(alpha)
)

@Preview
@Composable
fun ButtonScreenSkeletonPreview() {
    ComposeComponentsTheme() {
        ButtonScreenSkeleton()
    }
}