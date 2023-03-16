package com.codedev.base.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codedev.base.Colors

@Composable
fun BottomNavigation(scope: @Composable BottomNavigationScope.() -> Unit) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//    val currentDestination = navBackStackEntry?.destination
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Colors.ColorSurface)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavigationScope.scope()
    }
}

object BottomNavigationScope {
    @Composable
    fun composeItem(
        title: String,
        icon: ImageVector,
        selected: Boolean,
        onClick: () -> Unit
    ) {
        BottomNavigationItem(
            title = title,
            selected = selected,
            onClick = onClick,
            icon = icon
        )
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    BottomNavigation {
        composeItem(
            title = "Home",
            icon = Icons.Outlined.Home,
            selected = true
        ) {}
        composeItem(
            title = "Bookmarks",
            icon = Icons.Outlined.Home,
            selected = true
        ) {}
        composeItem(
            title = "History",
            icon = Icons.Outlined.Home,
            selected = true
        ) {}
    }
}