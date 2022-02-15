package com.josehumaneshumanes.canvasdemo.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BaseViewModel: ViewModel() {
    private val _title = mutableStateOf("")
    val title: State<String>
        get() = _title

    fun changeTitle(title: String) {
        println(title)
        _title.value = title
    }
}
