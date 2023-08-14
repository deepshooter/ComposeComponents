package com.deepshooter.composecomponents.ui.animations.index

import com.deepshooter.composecomponents.ui.AnimationsScreen

data class Animation(
    val name: String,
    val route: AnimationsScreen
) {

    companion object {
        val animationsList = listOf(
            Animation(
                name = "Bubbles",
                route = AnimationsScreen.AnimationsBubbles
            )
        )
    }

}
