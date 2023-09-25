package com.deepshooter.composecomponents.ui.modules.components.swipetodismiss

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppConstant.SWIPE_TO_DISMISS
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay


@Composable
fun SwipeToDismissScreen(
    goBack: () -> Unit
) {
    SwipeToDismissScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SwipeToDismissScreenSkeleton(
    goBack: () -> Unit = {},
) {
    EmailList()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailList(emailViewModel: EmailViewModel = viewModel()) {
    // Collect the state of messages from the view model
    val messages by emailViewModel.messagesState.collectAsState()

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = SWIPE_TO_DISMISS) },
                    actions = {
                        // Refresh button
                        IconButton(onClick = emailViewModel::refresh) {
                            Icon(
                                Icons.Filled.Refresh,
                                contentDescription = stringResource(id = R.string.refresh)
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 12.dp),
            ) {
                itemsIndexed(
                    items = messages,
                    // Provide a unique key based on the email content
                    key = { _, item -> item.hashCode() }
                ) { _, emailContent ->
                    // Display each email item
                    EmailItem(emailContent, onRemove = emailViewModel::removeItem)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissBackground(dismissState: DismissState) {
    val color = when (dismissState.dismissDirection) {
        DismissDirection.StartToEnd -> Color(0xFFFF1744)
        DismissDirection.EndToStart -> Color(0xFF1DE9B6)
        null -> Color.Transparent
    }
    val direction = dismissState.dismissDirection

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(12.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (direction == DismissDirection.StartToEnd) Icon(
            Icons.Default.Delete,
            contentDescription = stringResource(R.string.delete)
        )
        Spacer(modifier = Modifier)
        if (direction == DismissDirection.EndToStart) Icon(
            // make sure add baseline_archive_24 resource to drawable folder
            painter = painterResource(R.drawable.baseline_archive_24),
            contentDescription = stringResource(R.string.archive)
        )
    }
}

@Composable
fun EmailMessageCard(emailMessage: EmailMessage) {
    ListItem(
        modifier = Modifier.clip(MaterialTheme.shapes.small),
        headlineContent = {
            Text(
                emailMessage.sender,
                style = MaterialTheme.typography.titleMedium
            )
        },
        supportingContent = {
            Text(
                emailMessage.message,
                style = MaterialTheme.typography.bodySmall
            )
        },
        leadingContent = {
            Icon(
                Icons.Filled.Person,
                contentDescription = stringResource(R.string.person_icon),
                Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(10.dp)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailItem(
    emailMessage: EmailMessage,
    onRemove: (EmailMessage) -> Unit
) {
    val context = LocalContext.current
    var show by remember { mutableStateOf(true) }
    val currentItem by rememberUpdatedState(emailMessage)
    val dismissState = rememberDismissState(
        confirmValueChange = {
            if (it == DismissValue.DismissedToStart || it == DismissValue.DismissedToEnd) {
                show = false
                true
            } else false
        }, positionalThreshold = { 150.dp.toPx() }
    )
    AnimatedVisibility(
        show, exit = fadeOut(spring())
    ) {
        SwipeToDismiss(
            state = dismissState,
            modifier = Modifier,
            background = {
                DismissBackground(dismissState)
            },
            dismissContent = {
                EmailMessageCard(emailMessage)
            }
        )
    }

    LaunchedEffect(show) {
        if (!show) {
            delay(800)
            onRemove(currentItem)
            Toast.makeText(context, "Item Removed", Toast.LENGTH_SHORT).show()
        }
    }
}

@Preview
@Composable
fun SwipeToDismissScreenSkeletonPreview() {
    ComposeComponentsTheme {
        SwipeToDismissScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SwipeToDismissScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        SwipeToDismissScreenSkeleton()
    }
}