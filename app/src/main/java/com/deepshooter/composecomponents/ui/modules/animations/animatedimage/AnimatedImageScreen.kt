package com.deepshooter.composecomponents.ui.modules.animations.animatedimage

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun AnimatedImageScreen() {
    AnimatedImage()
}


@Composable
fun AnimatedImage() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var state by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            val startDelay = Random.nextLong(300, 900)
            delay(startDelay)
            state = true
        }

        LaunchedEffect(Unit) {
            while (true) {
                val startDelay = Random.nextLong(300, 900)
                delay(startDelay)
                state = true
                delay(3000)
                state = false
                delay(2000 - startDelay)
            }
        }

        val animAlpha by animateFloatAsState(
            targetValue = if (state) 1f else 0f,
            animationSpec = tween(
                durationMillis = 900,
                easing = FastOutSlowInEasing
            )
        )

        val animRotation by animateFloatAsState(
            targetValue = if (state) 360f else 0f,
            animationSpec = tween(
                durationMillis = 900,
                easing = FastOutSlowInEasing
            )
        )

        val animScale by animateFloatAsState(
            targetValue = if (state) 1f else 0f,
            animationSpec = tween(
                durationMillis = 900,
                easing = FastOutSlowInEasing
            )
        )

        Image(
            modifier = Modifier
                .size(160.dp)
                .graphicsLayer {
                    alpha = animAlpha
                    rotationX = animRotation
                    rotationY = animRotation
                    rotationZ = animRotation
                    scaleX = animScale
                    scaleY = animScale
                },
            painter = painterResource(id = R.drawable.ic_android_logo),
            contentDescription = stringResource(id = R.string.android)
        )
    }
}


@Preview
@Composable
fun AnimatedImageScreenPreview() {
    ComposeComponentsTheme {
        AnimatedImage()
    }
}

