package com.deepshooter.composecomponents.ui.modules.components.listitem

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepshooter.composecomponents.R
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.utils.AppComponent
import com.deepshooter.composecomponents.utils.AppConstant.LIST_ITEM


@Composable
fun ListItemScreen(
    goBack: () -> Unit
) {
    ListItemScreenSkeleton(
        goBack = goBack
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListItemScreenSkeleton(
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
                LIST_ITEM,
                goBack = goBack
            )

            Divider()


            /** One-line items */

            val scrollState = rememberScrollState()

            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(0.dp)
            ) {

                ListItem(headlineContent = { Text(stringResource(R.string.one_line_list_item_with_no_icon)) })
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.one_line_list_item_with_24x24_icon)) },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null
                        )
                    }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.one_line_list_item_with_40x40_icon)) },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.one_line_list_item_with_56x56_icon)) },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(56.dp)
                        )
                    }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.one_line_clickable_list_item)) },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(56.dp)
                        )
                    },
                    modifier = Modifier.clickable { }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.one_line_list_item_with_trailing_icon)) },
                    trailingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null
                        )
                    }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.one_line_list_item)) },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    },
                    trailingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null
                        )
                    }
                )
                Divider()

                /** Two-line items */

                ListItem(
                    headlineContent = { Text(stringResource(R.string.two_line_list_item)) },
                    supportingContent = { Text(stringResource(R.string.secondary_text)) }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.two_line_list_item)) },
                    overlineContent = { Text(stringResource(R.string.overline)) }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.two_line_list_item_with_24x24_icon)) },
                    supportingContent = { Text(stringResource(R.string.secondary_text)) },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null
                        )
                    }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.two_line_list_item_with_40x40_icon)) },
                    supportingContent = { Text(stringResource(R.string.secondary_text)) },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                )
                Divider()
                ListItem(
                    headlineContent = { Text(stringResource(R.string.two_line_list_item_with_40x40_icon)) },
                    supportingContent = { Text(stringResource(R.string.secondary_text)) },
                    trailingContent = { Text(stringResource(R.string.free)) },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                )
                Divider()

                /** Three-line items */

                ListItem(
                    headlineContent = { Text(stringResource(R.string.three_line_list_item)) },
                    supportingContent = {
                        Text(
                            stringResource(R.string.this_is_a_long_secondary_text_for_the_current_list_item) +
                                    stringResource(R.string.displayed_on_two_lines)
                        )
                    },
                    trailingContent = { Text(stringResource(R.string.free)) }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.three_line_list_item)) },
                    overlineContent = { Text(stringResource(id = R.string.overline)) },
                    supportingContent = { Text(stringResource(R.string.secondary_text)) }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.three_line_list_item_with_24x24_icon)) },
                    supportingContent = {
                        Text(
                            stringResource(R.string.this_is_a_long_secondary_text_for_the_current_list_item) +
                                    stringResource(R.string.displayed_on_two_lines)
                        )
                    },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null
                        )
                    }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(R.string.three_line_list_item_with_trailing_icon)) },
                    supportingContent = {
                        Text(
                            stringResource(R.string.this_is_a_long_secondary_text_for_the_current_list_item) +
                                    stringResource(R.string.displayed_on_two_lines)
                        )
                    },
                    trailingContent = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null
                        )
                    }
                )
                Divider()

                ListItem(
                    headlineContent = { Text(stringResource(id = R.string.three_line_list_item)) },
                    overlineContent = { Text(stringResource(id = R.string.overline)) },
                    supportingContent = { Text(stringResource(id = R.string.secondary_text)) },
                    trailingContent = { Text(stringResource(id = R.string.free)) }
                )
                Divider()


                /** ListItem With CheckBox or Switch */

                var switched by remember { mutableStateOf(false) }
                val onSwitchedChange: (Boolean) -> Unit = { switched = it }
                ListItem(
                    headlineContent = { Text(stringResource(R.string.switch_listitem)) },
                    trailingContent = {
                        Switch(
                            checked = switched,
                            onCheckedChange = null
                        )
                    },
                    modifier = Modifier.toggleable(
                        value = switched,
                        onValueChange = onSwitchedChange
                    )
                )
                Divider()

                var checked by remember { mutableStateOf(true) }
                val onCheckedChange: (Boolean) -> Unit = { checked = it }
                ListItem(
                    headlineContent = { Text(stringResource(R.string.checkbox_listitem)) },
                    trailingContent = {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = null
                        )
                    },
                    modifier = Modifier.toggleable(
                        value = checked,
                        onValueChange = onCheckedChange
                    )
                )
                Divider()



            }


        }
    }
}


@Preview
@Composable
fun ListItemScreenSkeletonPreview() {
    ComposeComponentsTheme {
        ListItemScreenSkeleton()
    }
}

@Preview
@Composable
fun ListItemScreenSkeletonPreviewDark() {
    ComposeComponentsTheme(
        darkTheme = true
    ) {
        ListItemScreenSkeleton()
    }
}