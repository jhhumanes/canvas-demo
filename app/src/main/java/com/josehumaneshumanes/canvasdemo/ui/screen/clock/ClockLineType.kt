package com.josehumaneshumanes.canvasdemo.ui.screen.clock

import androidx.compose.ui.unit.Dp

sealed class ClockLineType {
    object LongLine : ClockLineType()
    object ShortLine : ClockLineType()
}
