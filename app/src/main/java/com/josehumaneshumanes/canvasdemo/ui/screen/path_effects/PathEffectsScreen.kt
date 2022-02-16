package com.josehumaneshumanes.canvasdemo.ui.screen.path_effects

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josehumaneshumanes.canvasdemo.R
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseViewModel

@Composable
fun PathEffectsScreen() {
    val baseViewModel: BaseViewModel = viewModel()
    baseViewModel.changeTitle(stringResource(id = R.string.path_effects))

    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10_000f,
        animationSpec = infiniteRepeatable(
            animation = tween(60_000, easing = LinearEasing)
        )
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(100f, 100f)
            cubicTo(100f, 300f, 600f, 700f, 600f, 1100f)
            lineTo(800f, 800f)
            lineTo(1_000f, 1_100f)
        }

        val oval = Path().apply {
            addOval(Rect(topLeft = Offset.Zero, bottomRight = Offset(40f, 10f)))
        }

        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
//                pathEffect = PathEffect.dashPathEffect(
//                    intervals = floatArrayOf(50f, 30f),
//                    phase = phase
//                )
//                pathEffect = PathEffect.cornerPathEffect(
//                    radius = 1_000f
//                )
                pathEffect = PathEffect.stampedPathEffect(
                    shape = oval,
                    advance = 100f,
                    phase = phase,
                    style = StampedPathEffectStyle.Morph
                )
//                pathEffect = PathEffect.chainPathEffect(
//                    outer = PathEffect.stampedPathEffect(
//                        shape = oval,
//                        advance = 30f,
//                        phase = 0f,
//                        style = StampedPathEffectStyle.Rotate
//                    ),
//                    inner = PathEffect.dashPathEffect(
//                        intervals = floatArrayOf(100f, 100f)
//                    )
//                )
            )
        )
    }
}