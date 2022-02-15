package com.josehumaneshumanes.canvasdemo.ui.screen.path_basics

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josehumaneshumanes.canvasdemo.R
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseViewModel

@Composable
fun PathBasicsScreen() {
    val baseViewModel: BaseViewModel = viewModel()
    baseViewModel.changeTitle(stringResource(id = R.string.path_basics))

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val path = Path().apply {
            //moveTo(100f, 100f)
            moveTo(1000f, 100f)
            lineTo(100f, 500f)
            lineTo(500f, 500f)
            //lineTo(500f, 100f)
//            quadraticBezierTo(
//                800f, 300f, // punto de control
//                500f, 100f, // punto final
//            )
            cubicTo(
                800f, 500f, // punto de control 1
                800f, 100f, // punto de control 2
                500f, 100f, // punto final
            )
            //close() // lineTo(100f, 100f)
        }
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 10.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Miter,
                miter = 20f
            )
        )
    }
}
