package com.sss.gudzillaapps.common.component

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BackgroundGradient(
    content: @Composable BoxScope.() -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAF8))
    ) {
        val screenWidthPx = with(LocalDensity.current) { maxWidth.toPx() }

        // Layer 1: Hijau dari pojok kiri atas (warna logo dragon)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0x381A6B3A), // hijau gelap, opacity ~22%
                            Color(0x141A6B3A), // hijau gelap, opacity ~8%
                            Color.Transparent
                        ),
                        center = Offset(0f, 0f),
                        radius = screenWidthPx * 1.1f
                    )
                )
        )

        // Layer 2: Gold dari pojok kanan atas (warna teks GUDZILLAS3)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0x4DC49A3C), // gold, opacity ~30%
                            Color(0x1AC49A3C), // gold, opacity ~10%
                            Color.Transparent
                        ),
                        center = Offset(screenWidthPx, 0f),
                        radius = screenWidthPx * 0.9f
                    )
                )
        )

        // Layer 3: Vertical fade tipis dari atas supaya smooth
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0x2EC49A3C),
                            Color.Transparent
                        )
                    )
                )
        )

        content()
    }
}

fun Modifier.coloredShadow(
    color: Color,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 20.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 4.dp,
    spread: Float = 1f,
) = this.drawBehind {
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        val spreadPixel = spread.dp.toPx()
        val leftPixel = (0f - spreadPixel) + offsetX.toPx()
        val topPixel = (0f - spreadPixel) + offsetY.toPx()
        val rightPixel = (this.size.width + spreadPixel)
        val bottomPixel = (this.size.height + spreadPixel)

        if (blurRadius != 0.dp) {
            frameworkPaint.maskFilter =
                BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL)
        }

        frameworkPaint.color = color.toArgb()
        it.drawRoundRect(
            left = leftPixel,
            top = topPixel,
            right = rightPixel,
            bottom = bottomPixel,
            radiusX = borderRadius.toPx(),
            radiusY = borderRadius.toPx(),
            paint = paint
        )
    }
}