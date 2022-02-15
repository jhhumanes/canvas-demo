package com.josehumaneshumanes.canvasdemo.ui.screen.weight_picker

sealed class LineType {
    object Normal : LineType()
    object FiveStep : LineType()
    object TenStep : LineType()
}
