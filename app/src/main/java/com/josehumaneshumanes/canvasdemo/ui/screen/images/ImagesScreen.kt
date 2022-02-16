package com.josehumaneshumanes.canvasdemo.ui.screen.images

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josehumaneshumanes.canvasdemo.R
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseViewModel

@Composable
fun ImagesScreen() {
    val baseViewModel: BaseViewModel = viewModel()
    baseViewModel.changeTitle(stringResource(id = R.string.images))

    val ateam = ImageBitmap.imageResource(id = R.drawable.ateam)

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawImage(
            image = ateam,
            dstOffset = IntOffset(100, 100),
            dstSize = IntSize(
                (500 * (ateam.width.toFloat() / ateam.height)).toInt(),
                500
            )
        )
        drawCircle(
            color = Color.Red,
            radius = 250f,
            center = Offset(350f, 350f),
            //blendMode = BlendMode.Color
            blendMode = BlendMode.Multiply
        )
    }
}