package com.josehumaneshumanes.canvasdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.josehumaneshumanes.canvasdemo.ui.CanvasDemoApp
import com.josehumaneshumanes.canvasdemo.ui.navigation.Navigation
import com.josehumaneshumanes.canvasdemo.ui.theme.CanvasDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasDemoApp()
        }
    }
}
