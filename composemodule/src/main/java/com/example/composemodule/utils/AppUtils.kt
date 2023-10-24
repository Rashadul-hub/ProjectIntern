package com.example.composemodule.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import com.example.composemodule.model.Dimensions
import com.example.composemodule.model.smallDimensions

@Composable
fun ProvideAppUtils(
    dimensions: Dimensions,
    orientation: Orientation,
    content: @Composable () ->Unit
) {
    val dimSet = remember{dimensions}
    val orientation = remember {orientation}

    CompositionLocalProvider (
        LocalAppDimens provides dimSet,
        LocalOrientationMode provides orientation,
        content = content
    )


}


val LocalAppDimens = compositionLocalOf {
    smallDimensions
}
val LocalOrientationMode = compositionLocalOf {
    Orientation.Portrait
}