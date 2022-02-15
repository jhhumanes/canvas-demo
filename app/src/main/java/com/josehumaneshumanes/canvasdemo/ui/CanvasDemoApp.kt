package com.josehumaneshumanes.canvasdemo.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.josehumaneshumanes.canvasdemo.ui.navigation.Navigation
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseScreen
import com.josehumaneshumanes.canvasdemo.ui.theme.CanvasDemoTheme

@Composable
fun CanvasDemoApp() {
    CanvasDemoTheme {
        BaseScreen()
    }
}
