package com.deepshooter.composecomponents.ui.tictactoe

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
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
import com.deepshooter.composecomponents.utils.AppComponent


@Composable
fun TicTacToeIndexScreen(
    viewModel: TicTacToeViewModel,
    goBack: () -> Unit
) {

    val context = LocalContext.current

    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.toast) {
        state.toast?.getValueOnce()?.let { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    TicTacToeScreenSkeleton(
        loading = state.loading,
        message = state.message,
        paused = state.paused,
        userWinCount = state.userWinCount,
        aiWinCount = state.aiWinCount,
        currentPlayingMoves = state.currentPlayingMoves,
        totalNeurons = state.totalNeurons,
        winPosition = state.winPosition,
        goBack = goBack,
        onBoxClicked = { position ->
            viewModel.act(
                position = position
            )
        },
        onRestartClicked = {
            viewModel.restart()
        }
    )
}


@Composable
fun TicTacToeScreenSkeleton(
    loading: Boolean = false,
    message: Event<String>? = null,
    paused: Boolean = false,
    userWinCount: Int = 0,
    aiWinCount: Int = 0,
    currentPlayingMoves: String = "",
    totalNeurons: Int = 0,
    winPosition: WinPosition? = null,
    goBack: () -> Unit = {},
    onBoxClicked: (position: Int) -> Unit = {},
    onRestartClicked: () -> Unit = {}
) {

    val snackBarHostState: SnackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(message) {
        message?.getValueOnce()?.let { value ->
            val result = snackBarHostState.showSnackbar(
                message = value,
                actionLabel = "Play Again",
                duration = SnackbarDuration.Indefinite
            )

            if (result == SnackbarResult.ActionPerformed) {
                onRestartClicked()
            }
        }
    }

    Scaffold(
        Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding(),
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {

        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            AppComponent.Header(
                "Tic-Tac-Toe",
                goBack = goBack
            )

            Divider()
            AppComponent.MediumSpacer()

            Row(Modifier.padding(start = 16.dp, end = 16.dp)) {
                Column(
                    Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "You",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$userWinCount",
                        fontSize = 32.sp
                    )
                }

                Column(
                    Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "AI",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$aiWinCount",
                        fontSize = 32.sp
                    )
                }
            }

            AppComponent.MediumSpacer()

            Box(Modifier.fillMaxWidth()) {
                Column(
                    Modifier
                        .padding(start = 32.dp, end = 32.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        for (i in 1..3) {
                            Block(
                                position = i,
                                currentPlayingMoves = currentPlayingMoves,
                                enabled = !paused,
                                isMarked = winPosition != null && i in winPosition.places,
                                onClick = {
                                    onBoxClicked(i)
                                }
                            )
                        }
                    }
                    Row(Modifier.fillMaxWidth()) {
                        for (i in 4..6) {
                            Block(
                                position = i,
                                currentPlayingMoves = currentPlayingMoves,
                                enabled = !paused,
                                isMarked = winPosition != null && i in winPosition.places,
                                onClick = {
                                    onBoxClicked(i)
                                }
                            )
                        }
                    }
                    Row(Modifier.fillMaxWidth()) {
                        for (i in 7..9) {
                            Block(
                                position = i,
                                currentPlayingMoves = currentPlayingMoves,
                                enabled = !paused,
                                isMarked = winPosition != null && i in winPosition.places,
                                onClick = {
                                    onBoxClicked(i)
                                }
                            )
                        }
                    }
                }
            }

            AppComponent.MediumSpacer()

            Text(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp)
                    .fillMaxWidth(),
                text = buildAnnotatedString {
                    append("Total Neurons: ")

                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("$totalNeurons")
                    }
                },
                textAlign = TextAlign.Center
            )

            AppComponent.BigSpacer()
        }

        AnimatedVisibility(
            visible = loading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.onBackground.copy(.5f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Working...",
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}


@Composable
fun RowScope.Block(
    position: Int,
    currentPlayingMoves: String,
    enabled: Boolean,
    isMarked: Boolean,
    onClick: () -> Unit = {}
) {

    var currentPiece by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(currentPlayingMoves) {
        currentPiece = getPiece(position, currentPlayingMoves)
    }

    val backgroundColor by animateColorAsState(
        targetValue = if (isMarked) {
            MaterialTheme.colorScheme.error
        } else {
            MaterialTheme.colorScheme.background
        }
    )

    val iconColor by animateColorAsState(
        targetValue = if (isMarked) {
            MaterialTheme.colorScheme.onError
        } else {
            MaterialTheme.colorScheme.onBackground
        }
    )

    Box(
        Modifier
            .padding(4.dp)
            .clip(CircleShape)
            .weight(1f)
            .aspectRatio(1f)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(.15f),
                shape = CircleShape
            )
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .clickable(
                indication = if (currentPiece == null) LocalIndication.current else null,
                interactionSource = remember { MutableInteractionSource() },
                enabled = enabled
            ) {
                if (currentPiece == null) {
                    onClick()
                }
            },
        contentAlignment = Alignment.Center
    ) {

        AnimatedContent(
            targetState = currentPiece
        ) { targetCurrentPiece ->
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                painter = painterResource(
                    id = when (targetCurrentPiece) {
                        Piece.X.value -> R.drawable.ic_x
                        Piece.O.value -> R.drawable.ic_o
                        else -> R.drawable.ic_blank
                    }
                ),
                contentDescription = targetCurrentPiece,
                colorFilter = ColorFilter.tint(iconColor)
            )
        }
    }

}

/**
 * Example of [currentPlayingMoves]:
 *
 * 1O3O5X7X9O2X4X6X8O
 */
private fun getPiece(position: Int, currentPlayingMoves: String): String? {
    val targetPosition = currentPlayingMoves.indexOf(position.toString())

    return if (targetPosition == -1) {
        null
    } else {
        currentPlayingMoves.getOrNull(targetPosition + 1)?.toString()
    }
}

@Preview
@Composable
fun TicTacToeScreenSkeletonPreview() {
    ComposeComponentsTheme() {
        TicTacToeScreenSkeleton(
            currentPlayingMoves = "1O3O5X7X9O2X4X6X8O"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TicTacToeScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        TicTacToeScreenSkeleton(
            currentPlayingMoves = "1O3O5X7X9O2X4X6X8O"
        )
    }
}

