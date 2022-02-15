package com.josehumaneshumanes.canvasdemo.ui.screen.path_operations

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josehumaneshumanes.canvasdemo.R
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseViewModel

@Composable
fun PathOperationsScreen() {
    val baseViewModel: BaseViewModel = viewModel()
    baseViewModel.changeTitle(stringResource(id = R.string.path_operations))

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val squareWithoutOp = Path().apply {
            addRect(
                Rect(
                    Offset(200f, 200f),
                    Size(200f, 200f)
                )
            )
        }
        val circle = Path().apply {
            addOval(
                Rect(
                    Offset(200f, 200f),
                    100f
                )
            )
        }
        val pathWithOp = Path().apply {
            op(
                squareWithoutOp,
                circle,
                //PathOperation.Difference
                PathOperation.ReverseDifference
                //PathOperation.Union
                //PathOperation.Intersect
                //PathOperation.Xor
            )
        }

        drawPath(
            path = squareWithoutOp,
            color = Color.Red,
            style = Stroke(
                width = 2.dp.toPx()
            )
        )

        drawPath(
            path = circle,
            color = Color.Blue,
            style = Stroke(
                width = 2.dp.toPx()
            )
        )

        drawPath(
            path = pathWithOp,
            color = Color.Green
        )
    }
}
