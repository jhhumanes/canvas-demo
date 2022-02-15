package com.josehumaneshumanes.canvasdemo.ui.screen.clock

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josehumaneshumanes.canvasdemo.R
import com.josehumaneshumanes.canvasdemo.ui.screen.BaseViewModel
import kotlinx.coroutines.delay
import java.time.LocalTime
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@SuppressLint("NewApi")
@Composable
fun ClockScreen(
    modifier: Modifier = Modifier
) {
    val baseViewModel: BaseViewModel = viewModel()
    baseViewModel.changeTitle(stringResource(id = R.string.clock))

    val currentTime = LocalTime.now()

    var seconds by rememberSaveable {
        mutableStateOf(currentTime.second)
    }
    var minutes by rememberSaveable {
        mutableStateOf(currentTime.minute)
    }
    var hours by rememberSaveable {
        mutableStateOf(if (currentTime.hour <= 12) currentTime.hour else currentTime.hour - 12)
    }

    LaunchedEffect(key1 = seconds) {
        delay(1000)
        if (seconds + 1 == 60) {
            seconds = 0
            if (minutes + 1 == 60) {
                minutes = 0
                if (hours + 1 == 12) {
                    hours = 0
                } else {
                    hours++
                }
            } else {
                minutes++
            }
        } else {
            seconds++
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Clock(
            seconds = seconds,
            minutes = minutes,
            hours = hours,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
fun Clock(
    seconds: Int = 0,
    minutes: Int = 0,
    hours: Int = 0,
    modifier: Modifier = Modifier,
    radius: Dp = 100.dp
) {
    Canvas(modifier = modifier) {
        // Draw circle.
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                center.x,
                center.y,
                radius.toPx(),
                Paint().apply {
                    color = Color.WHITE
                    setShadowLayer(
                        60f,
                        0f,
                        0f,
                        Color.argb(50, 0, 0, 0)
                    )
                }
            )
        }

        // Draw Lines
        for (i in 0..360 step 6) {
            val angleInRad = i * PI / 180
            val lineType = when {
                i % 10 == 0 -> ClockLineType.LongLine
                else -> ClockLineType.ShortLine
            }
            val lineLength = when (lineType) {
                ClockLineType.LongLine -> radius.toPx() / 5f
                ClockLineType.ShortLine -> (radius.toPx() / 5f) - (radius.toPx() / 5f) * 0.25f
            }
            val lineWidth = when (lineType) {
                ClockLineType.LongLine -> 4f
                ClockLineType.ShortLine -> 2f
            }
            val start = Offset(
                x = radius.toPx() * cos(angleInRad).toFloat() + center.x,
                y = radius.toPx() * sin(angleInRad).toFloat() + center.y
            )
            val end = Offset(
                x = (radius.toPx() - lineLength) * cos(angleInRad).toFloat() + center.x,
                y = (radius.toPx() - lineLength) * sin(angleInRad).toFloat() + center.y
            )

            drawLine(
                color = androidx.compose.ui.graphics.Color.Black,
                start = start,
                end = end,
                strokeWidth = lineWidth
            )
        }

        // Draw seconds
        val secondsAngleInRad = (seconds * (360 / 60) + 270) * PI / 180f
        val secondsStart = Offset(
            x = center.x,
            y = center.y,
        )
        val secondsEnd = Offset(
            x = (radius.toPx() - radius.toPx() / 5f) * cos(secondsAngleInRad).toFloat() + center.x,
            y = (radius.toPx() - radius.toPx() / 5f) * sin(secondsAngleInRad).toFloat() + center.y,
        )
        drawLine(
            color = androidx.compose.ui.graphics.Color.Red,
            start = secondsStart,
            end = secondsEnd,
            strokeWidth = 4f
        )

        // Draw minutes
        val minutesAngleInRad = (minutes * (360 / 60) + 270) * PI / 180f
        val minutesStart = Offset(
            x = center.x,
            y = center.y,
        )
        val minutesEnd = Offset(
            x = (radius.toPx() - radius.toPx() / 5f - 40f) * cos(minutesAngleInRad).toFloat() + center.x,
            y = (radius.toPx() - radius.toPx() / 5f - 40f) * sin(minutesAngleInRad).toFloat() + center.y,
        )
        drawLine(
            color = androidx.compose.ui.graphics.Color.DarkGray,
            start = minutesStart,
            end = minutesEnd,
            strokeWidth = 8f
        )

        // Draw hours
        val hoursAngleInRad = (hours * (360 / 12) + 270) * PI / 180f
        val hoursStart = Offset(
            x = center.x,
            y = center.y,
        )
        val hoursEnd = Offset(
            x = (radius.toPx() - radius.toPx() / 5f - 5f) * cos(hoursAngleInRad).toFloat() + center.x,
            y = (radius.toPx() - radius.toPx() / 5f - 5f) * sin(hoursAngleInRad).toFloat() + center.y,
        )
        drawLine(
            color = androidx.compose.ui.graphics.Color.Black,
            start = hoursStart,
            end = hoursEnd,
            strokeWidth = 4f
        )
    }
}
