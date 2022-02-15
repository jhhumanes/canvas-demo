package com.josehumaneshumanes.canvasdemo.ui.screen.draw_text

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josehumaneshumanes.canvasdemo.R
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseViewModel

@Composable
fun DrawTextScreen(
    modifier: Modifier = Modifier
) {
    val baseViewModel: BaseViewModel = viewModel()
    baseViewModel.changeTitle(stringResource(id = R.string.draw_text))

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        drawContext.canvas.nativeCanvas.apply {
            drawText(
                "Buenos días y buena suerte...",
                100f,
                100f,
                Paint().apply {
                    color = android.graphics.Color.WHITE
                    textSize = 100f
                }
            )
        }
    }
}
