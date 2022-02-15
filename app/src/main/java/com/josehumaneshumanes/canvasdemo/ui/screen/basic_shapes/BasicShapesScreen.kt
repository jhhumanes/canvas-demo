package com.josehumaneshumanes.canvasdemo.ui.screen.basic_shapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josehumaneshumanes.canvasdemo.R
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseViewModel

@Composable
fun BasicShapesScreen(
    modifier: Modifier = Modifier
) {
    val baseViewModel: BaseViewModel = viewModel()
    baseViewModel.changeTitle(stringResource(id = R.string.basic_shapes))

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        drawRect(
            color = Color.Red,
            topLeft = Offset(100.dp.toPx(), 100.dp.toPx()),
            size = Size(200f, 100f),
            style = Stroke(width = 5f)
        )

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color.Red, Color.Yellow),
                center = center,
                radius = 50.dp.toPx()
            ),
            center = center,
            radius = 50.dp.toPx()
        )

        drawArc(
            color = Color.Green,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = true,
            topLeft = Offset(650f, 200f),
            size = Size(200f, 200f),
            style = Stroke(width = 3.dp.toPx())
        )

        drawArc(
            color = Color.Magenta,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = false,
            topLeft = Offset(750f, 700f),
            size = Size(200f, 200f),
            style = Stroke(width = 3.dp.toPx())
        )

        drawArc(
            color = Color.Magenta,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = false,
            topLeft = Offset(50f, 700f),
            size = Size(200f, 200f)
        )

        drawOval(
            color = Color.Blue,
            topLeft = Offset(50f, 1100f),
            size = Size(200f, 300f)
        )

        drawLine(
            color = Color.Cyan,
            start = Offset(50f, 1500f),
            end = Offset(900f, 800f),
            strokeWidth = 5.dp.toPx()
        )
    }
}
