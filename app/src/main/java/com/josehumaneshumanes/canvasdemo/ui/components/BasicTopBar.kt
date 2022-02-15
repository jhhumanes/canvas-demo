package com.josehumaneshumanes.canvasdemo.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicTopBar(
    title: String,
    onIconClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = onIconClicked) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = modifier.size(40.dp)
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant,
    )
}