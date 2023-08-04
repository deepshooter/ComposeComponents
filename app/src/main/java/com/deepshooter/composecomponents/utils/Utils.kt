package com.deepshooter.composecomponents.utils

import android.graphics.Color
import java.util.Random


object Utils {

    val myRandomColor: Int
        get() {
            return Color.rgb((30..200).random(), (30..200).random(), (30..200).random())
        }

    fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

}