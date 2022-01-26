package com.javier.matetutoriasandroid

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs


fun Path.standarQuadFromTo(from: Offset, to: Offset){
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2,
        abs(from.y + to.y) / 2
    )
}