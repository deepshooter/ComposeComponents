package com.deepshooter.composecomponents.ui.modules.components.dropdownmenu

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.DROPDOWN_MENU

private val ELEMENT_HEIGHT = 48.dp


@Composable
fun DropDownMenuScreen(
    goBack: () -> Unit
) {
    DropDownMenuScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DropDownMenuScreenSkeleton(
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
                DROPDOWN_MENU,
                goBack = goBack
            )

            Divider()

            AppComponent.SubHeader(stringResource(R.string.menu))

            SimpleMenu()

            Divider()

            AppComponent.SubHeader(stringResource(R.string.spinner))

            AppComponent.MediumSpacer()

            val countryList = listOf(
                stringResource(R.string.india),
                stringResource(R.string.netherlands),
                stringResource(R.string.france),
                stringResource(R.string.usa)
            )

            var selectedItem1 by remember { mutableStateOf("") }
            var selectedItem2 by remember { mutableStateOf("India") }

            DropDownSpinner(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                defaultText = stringResource(R.string.select_country),
                selectedItem = selectedItem1,
                onItemSelected = { index, item ->
                    selectedItem1 = item
                },
                itemList = countryList
            )

            DropDownSpinner(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                defaultText = stringResource(R.string.select_country),
                selectedItem = selectedItem2,
                onItemSelected = { index, item ->
                    selectedItem2 = item
                },
                itemList = countryList
            )

            AppComponent.BigSpacer()

        }

    }

}

@Composable
fun SimpleMenu() {

    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopCenter)
    ) {

        IconButton(onClick = { expanded = true }) {
            Icon(
                Icons.Default.MoreVert,
                contentDescription = stringResource(R.string.localized_description)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(stringResource(R.string.refresh)) },
                onClick = {
                    expanded = false
                    /* Handle refresh! */
                })

            DropdownMenuItem(
                text = { Text(stringResource(R.string.settings)) },
                onClick = {
                    expanded = false
                    /* Handle settings! */
                })

            Divider()

            DropdownMenuItem(
                text = { Text(stringResource(R.string.send_feedback)) },
                onClick = {
                    expanded = false
                    /* Handle send feedback! */
                })
        }
    }
}

@Composable
fun <E> DropDownSpinner(
    modifier: Modifier = Modifier,
    defaultText: String = stringResource(R.string.select),
    selectedItem: E,
    onItemSelected: (Int, E) -> Unit,
    itemList: List<E>?
) {
    var isOpen by remember { mutableStateOf(false) }

    Box(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .height(ELEMENT_HEIGHT),
        contentAlignment = Alignment.CenterStart
    ) {
        if (selectedItem == null || selectedItem.toString().isEmpty()) {
            Text(
                text = defaultText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 3.dp),
                color = MaterialTheme.colorScheme.onSurface.copy(.45f)
            )
        }

        Text(
            text = selectedItem?.toString() ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 32.dp, bottom = 3.dp),
            color = MaterialTheme.colorScheme.onSurface
        )

        DropdownMenu(
            modifier = Modifier.fillMaxWidth(.85f),
            expanded = isOpen,
            onDismissRequest = {
                isOpen = false
            }
        ) {
            itemList?.forEachIndexed { index, item ->
                DropdownMenuItem(
                    onClick = {
                        isOpen = false
                        onItemSelected(index, item)
                    },
                    text = { Text(item.toString()) }
                )
            }
        }

        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_arrow_down),
            contentDescription = stringResource(R.string.dropdown)
        )

        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .clickable(
                    onClick = { isOpen = true }
                )
        )
    }
}


@Preview
@Composable
fun DropDownMenuScreenSkeletonPreview() {
    ComposeComponentsTheme {
        DropDownMenuScreenSkeleton()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DropDownMenuScreenSkeletonPreviewDark() {
    ComposeComponentsTheme {
        DropDownMenuScreenSkeleton()
    }
}