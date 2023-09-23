package com.deepshooter.composecomponents.utils

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun rememberImagePainter(
    data: Any?,
    @DrawableRes placeholder: Int? = null,
    crossFade: Boolean = true
) = rememberAsyncImagePainter(
    ImageRequest.Builder(LocalContext.current)
        .data(data = data).apply(block = fun ImageRequest.Builder.() {
            crossfade(crossFade)
            placeholder?.let {
                placeholder(placeholder)
                error(placeholder)
                fallback(placeholder)
            }
        })
        .build()
)
