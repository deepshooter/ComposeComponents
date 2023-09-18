package com.deepshooter.composecomponents.ui.modules.components.index

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepshooter.composecomponents.ui.ComponentsScreen
import com.deepshooter.composecomponents.ui.theme.Blue500
import com.deepshooter.composecomponents.ui.theme.Bluish
import com.deepshooter.composecomponents.ui.theme.ComposeComponentsTheme
import com.deepshooter.composecomponents.ui.theme.Reddish
import com.deepshooter.composecomponents.ui.theme.Teal300
import com.deepshooter.composecomponents.utils.AppComponent.Header
import com.deepshooter.composecomponents.utils.AppConstant.COMPONENTS_TITLE
import com.deepshooter.composecomponents.utils.UIThemeController

@Composable
fun ComponentsIndexScreen(
    goBack: () -> Unit,
    navigate: (ComponentsScreen) -> Unit
) {
    ComponentsIndexSkeleton(
        goBack = goBack,
        navigate = navigate
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ComponentsIndexSkeleton(
    goBack: () -> Unit = {},
    navigate: (ComponentsScreen) -> Unit = {}
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

            Header(
                COMPONENTS_TITLE,
                goBack = goBack
            )

            Divider()

            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                itemsIndexed(Components.componentsList) { index, item ->
                    ComponentsListItem(components = item, index, navigate)
                }
            }
        }
    }
}

@Composable
fun ComponentsListItem(
    components: Components,
    index: Int,
    navigate: (ComponentsScreen) -> Unit = {}
) {

    val isDark by UIThemeController.isDarkMode.collectAsState()

    Card(
        modifier = Modifier
            .padding(
                top = 4.dp,
                bottom = 4.dp,
                start = 8.dp,
                end = 8.dp
            )
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable(onClick = { navigate(components.route) }),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
        ),
        /*colors = CardDefaults.cardColors(
            containerColor = if (isDark) {
                if (index % 2 == 0)
                    Yellow500
                else
                    Purple700
            } else {
                if (index % 2 == 0)
                    Teal300
                else
                    Blue500
            }
        ),*/
        shape = RoundedCornerShape(4.dp)
    ) {

        Box(Modifier.background(brush = if (isDark) gradientCardBackgroundDark() else gradientCardBackgroundLight())) {
            Text(
                modifier = Modifier
                    .padding(
                        24.dp
                    )
                    .fillMaxWidth(),
                text = components.name,
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun gradientCardBackgroundLight() = Brush.horizontalGradient(
    colors = listOf(
        Teal300,
        Blue500,
    )
)

@Composable
fun gradientCardBackgroundDark() = Brush.horizontalGradient(
    colors = listOf(
        Reddish,
        Bluish,
    )
)

@Preview
@Composable
fun CompositionIndexSkeletonPreview() {
    ComposeComponentsTheme {
        ComponentsIndexSkeleton()
    }
}