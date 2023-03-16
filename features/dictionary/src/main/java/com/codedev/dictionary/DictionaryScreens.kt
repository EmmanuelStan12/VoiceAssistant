package com.codedev.dictionary

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DictionaryScreens(
    val icon: ImageVector,
    val title: String,
    val route: String,
    val willNavigate: Boolean = true
) {
    object Home: DictionaryScreens(Icons.Outlined.Home, "Home", "home")
    object History: DictionaryScreens(Icons.Outlined.History, "History", "history")
    object Bookmarks: DictionaryScreens(Icons.Outlined.Bookmarks, "Bookmarks", "bookmarks")
    object Result: DictionaryScreens(Icons.Outlined.ResetTv, "Result", "result")
    object RandomWord: DictionaryScreens(Icons.Outlined.DateRange, "Random Word", "random_word", willNavigate = false)
    object Exit: DictionaryScreens(Icons.Outlined.FullscreenExit, "Exit", "exit", willNavigate = false)

    companion object {
        val navigationItems = listOf(
            Home,
            History,
            Bookmarks
        )
    }
}
