package com.example.ktmidi.demo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ktmidi-demo",
    ) {
        App()
    }
}