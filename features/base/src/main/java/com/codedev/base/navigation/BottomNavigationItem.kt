package com.codedev.base.navigation

import android.graphics.fonts.FontStyle
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codedev.base.Colors
import com.codedev.base.R


@Composable
fun BottomNavigationItem(
    selected: Boolean,
    title: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(if (selected) CircleShape else RoundedCornerShape(0.dp))
            .clickable { onClick() }
            .background(if (selected) Colors.ColorPrimary else Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(icon), contentDescription = null, tint = if (selected) Color.White else Colors.ColorNotSelected)
        Spacer(Modifier.height(8.dp))
        if (!selected) Text(text = title, style = MaterialTheme.typography.body1)
    }
}

@Composable
@Preview(showBackground = true)
fun BottomNavigationItemPreview() {
    BottomNavigationItem(
        selected = false,
        title = "Home",
        icon = R.drawable.ic_home,
    ) {

    }
}