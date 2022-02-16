package com.josehumaneshumanes.canvasdemo.ui.screen.transforming_clipping

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josehumaneshumanes.canvasdemo.R
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseViewModel

@Composable
fun TranformingClippingScreen() {
    val baseViewModel: BaseViewModel = viewModel()
    baseViewModel.changeTitle(stringResource(id = R.string.transforming_clipping))

    Canvas(modifier = Modifier.fillMaxSize()) {
        rotate(
            45f,
            pivot = Offset(200f, 200f)
        ) {
            drawRect(
                color = Color.Red,
                topLeft = Offset(100f, 100f),
                size = Size(200f, 200f)
            )
        }

        translate(
            left = 300f,
            top = 300f
        ) {
            rotate(
                45f,
                pivot = Offset(100f, 100f)
            ) {
                drawRect(
                    color = Color.Red,
                    topLeft = Offset(100f, 100f),
                    size = Size(200f, 200f)
                )
            }
        }

        scale(
            0.5f,
            pivot = Offset(200f, 200f)
        ) {
            drawRect(
                color = Color.Red,
                topLeft = Offset(300f, 400f),
                size = Size(200f, 200f)
            )
        }

        val circle = Path().apply {
            addOval(Rect(center = Offset(500f, 700f), radius = 300f))
        }
        drawPath(
            path = circle,
            color = Color.Green,
            style = Stroke(width = 5.dp.toPx())
        )
        clipPath(
            path = circle
        ) {
            drawRect(
                color = Color.Red,
                topLeft = Offset(500f, 800f),
                size = Size(400f, 400f)
            )
        }
    }
}