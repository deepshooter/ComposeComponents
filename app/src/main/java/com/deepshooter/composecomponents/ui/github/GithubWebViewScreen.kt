package com.deepshooter.composecomponents.ui.github

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Purple200
import com.deepshooter.composecomponents.ui.theme.Purple500
import com.deepshooter.composecomponents.ui.theme.Teal300
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private const val TAG = "GithubScreen"

sealed class WebViewTarget(val name: String, val url: String) {
    object Github : WebViewTarget(
        name = "Github",
        url = "https://github.com/deepshooter"
    )
}

@Composable
fun GithubWebViewScreen(
    viewModel: GithubViewModel,
    target: WebViewTarget,
    goBack: () -> Unit
) {

    val state by viewModel.state.collectAsState()

    BackHandler {
        if (viewModel.webViewCanGoBack()) {
            viewModel.webViewGoBack()
        } else {
            goBack()
        }
    }

    WebViewSkeleton(
        title = target.name,
        goBack = {
            goBack()
        },
        webView = { modifier ->
            WebViewContainer(
                modifier = modifier,
                url = target.url,
                loadingProgress = state.loadingProgress,
                initSwipeRefresh = viewModel::initSwipeRefresh,
                initWebView = viewModel::initWebView
            )
        },
        webViewError = state.error,
        onRetry = viewModel::webViewReload
    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebViewSkeleton(
    title: String,
    goBack: () -> Unit,
    webView: @Composable (Modifier) -> Unit,
    webViewError: WebViewError? = null,
    onRetry: () -> Unit = {}
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
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace,
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { goBack() }) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.ic_arrow_left_single
                            ),
                            contentDescription = "Back"
                        )
                    }
                }
            )

            Box(
                Modifier.weight(1f)
            ) {
                webView(Modifier.fillMaxSize())

                androidx.compose.animation.AnimatedVisibility(
                    visible = webViewError != null,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    webViewError?.let {
                        ErrorView(
                            errorCode = webViewError.errorCode,
                            description = webViewError.description,
                            failingUrl = webViewError.failingUrl,
                            onRetry = onRetry
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun WebViewContainer(
    modifier: Modifier,
    url: String,
    loadingProgress: Int?,
    initSwipeRefresh: (swipeRefreshLayout: SwipeRefreshLayout) -> Unit,
    initWebView: (webView: WebView) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier.fillMaxSize()) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    Log.d(TAG, "AndroidView: factory")

                    SwipeRefreshLayout(context).apply {
                        initSwipeRefresh(this)

                        addView(
                            WebView(context).apply {
                                id = R.id.webView

                                initWebView(this)
                            }
                        )
                    }
                },
                update = { swipeRefreshLayout ->
                    Log.d(TAG, "AndroidView: update")

                    val webView =
                        swipeRefreshLayout.findViewById<WebView>(R.id.webView)

                    swipeRefreshLayout.layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )

                    webView.layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )

                    webView.loadUrl(url)
                }
            )

            LoadingContainer(
                progress = loadingProgress ?: 0,
                visible = loadingProgress != null
            )
        }
    }
}

@Composable
private fun LoadingContainer(
    progress: Int,
    visible: Boolean = true
) {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Purple200,
        targetValue = Purple500,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Black.copy(.25f))
        ) {
            Row(
                Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .height(24.dp)
                    .padding(start = 32.dp, end = 32.dp)
                    .background(Color(0xffdddddd), CircleShape)
            ) {
                BoxWithConstraints {
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .clip(CircleShape)
                            .animateContentSize()
                            .width(maxWidth * progress / 100)
                            .background(color, CircleShape)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun LoadingContainerPreview() {
    val scope = rememberCoroutineScope()
    val progress = remember { mutableIntStateOf(0) }

    LaunchedEffect(true) {
        scope.launch {
            while (true) {
                progress.value = 0

                delay(1000)

                progress.value = 33

                delay(1000)

                progress.value = 66

                delay(1000)

                progress.value = 100

                delay(1000)
            }
        }
    }

    LoadingContainer(
        progress.value
    )
}

@Preview
@Composable
fun WebViewSkeletonPreview() {
    ComposeComponentsTheme() {
        WebViewSkeleton(
            title = WebViewTarget.Github.name,
            goBack = {},
            webView = {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Teal300)
                )
            }
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WebViewSkeletonPreviewDark() {
    ComposeComponentsTheme {
        WebViewSkeleton(
            title = WebViewTarget.Github.name,
            goBack = {},
            webView = {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Teal300)
                )
            }
        )
    }
}