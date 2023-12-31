package com.deepshooter.composecomponents.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceHelper @Inject constructor(@ApplicationContext context: Context) {

    private val context: Context = context.applicationContext

    @Volatile
    private var sharedPreferences: SharedPreferences? = null

    private fun getSharedPreferences(): SharedPreferences {
        return sharedPreferences ?: synchronized(this) {
            context.getSharedPreferences(
                "${context.packageName}.main",
                Context.MODE_PRIVATE
            )
        }
    }

    fun clearSharedPreferences() {
        getSharedPreferences().edit().clear().apply()
    }

    fun setDarkMode(isDark: Boolean) {
        getSharedPreferences()
            .edit()
            .apply {
                putBoolean(PREF_DARK_MODE, isDark)
                apply()
            }
    }

    fun getDarkMode(): Boolean {
        return getSharedPreferences().getBoolean(PREF_DARK_MODE, false)
    }

    fun setTicTacToeWin(data: Set<String>) {
        getSharedPreferences()
            .edit()
            .apply {
                putStringSet(PREF_TICTACTOE_WIN, data)
                apply()
            }
    }

    fun getTicTacToeWin(): Set<String> {
        return getSharedPreferences().getStringSet(PREF_TICTACTOE_WIN, emptySet()) ?: emptySet()
    }

    companion object {
        private const val PREF_DARK_MODE = "dark_mode"
        private const val PREF_TICTACTOE_WIN = "tictactoe_win"
    }

}