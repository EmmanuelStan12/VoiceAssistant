package com.codedev.dictionary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codedev.base.Colors
import com.codedev.base.navigation.BottomNavigation
import com.codedev.dictionary.composables.Bookmark
import com.codedev.dictionary.composables.History
import com.codedev.dictionary.composables.Home
import com.codedev.dictionary.composables.Result

@Composable
fun DictionaryGraph() {

    val navController = rememberNavController()
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.ColorBackground),
        bottomBar = {
                    BottomNavigation {
                        DictionaryScreens.navigationItems.forEachIndexed { index, screen ->
                            val isActive = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                            composeItem(
                                title = screen.title,
                                icon = screen.icon,
                                selected = isActive
                            ) {
                                navController.navigate(screen.route) {
                                    // TODO: remember to test this
                                    popUpTo(
                                        currentDestination?.route
                                            ?: navController.graph.findStartDestination().route
                                            ?: DictionaryScreens.Home.route
                                    ) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    }
        },
        scaffoldState = scaffoldState,
    ) { _ ->
        NavHost(
            startDestination = DictionaryScreens.Home.route,
            navController = navController,
        ) {
            composable(route = DictionaryScreens.Home.route) {
                Home()
            }
            composable(route = DictionaryScreens.Bookmarks.route) {
                Bookmark()
            }
            composable(route = DictionaryScreens.History.route) {
                History()
            }
            composable(
                route = "${DictionaryScreens.Result.route}/{word}",
                arguments = listOf(
                    navArgument("word") {
                        type = NavType.StringType
                        defaultValue = "Default"
                    }
                )
            ) { backStackEntry ->
                val word = backStackEntry.arguments?.getString("word") ?: ""
                Result()
            }
        }
    }
}