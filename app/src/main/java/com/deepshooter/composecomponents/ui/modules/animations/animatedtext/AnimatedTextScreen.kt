package com.deepshooter.composecomponents.ui.modules.animations.animatedtext

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.Pink500
import com.deepshooter.composecomponents.ui.theme.Pink700
import com.deepshooter.composecomponents.utils.UIThemeController
import kotlinx.coroutines.delay
import kotlin.random.Random


@Composable
fun AnimatedTextScreen() {
    AnimatedText(
        text = stringResource(id = R.string.android_love),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
    )
}

@Composable
fun AnimatedText(
    text: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            val isDark by UIThemeController.isDarkMode.collectAsState()

            text.forEach { char ->

                var state by remember { mutableStateOf(false) }

                LaunchedEffect(char) {
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

                Text(
                    text = char.toString(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.graphicsLayer {
                        alpha = animAlpha
                    },
                    color = if (isDark) Pink700 else Pink500
                )
            }
        }
    }
}