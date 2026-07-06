package com.sss.gudzillaapps.common.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun CustomCardGradient(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        shape = RoundedCornerShape(28.dp),
        color = Color(0xFFFFFEFC),
        shadowElevation = 12.dp,
        tonalElevation = 0.dp,
        border = BorderStroke(2.dp, Color(0xFFF2ECE0)),
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer {
                // Menyamakan arah jatuhnya shadow dari atas kiri seperti MenuCard Anda
                ambientShadowColor = Color(0xFFB8860B)
                spotShadowColor = Color(0xFF8B6210)
            }
    ) {
        Box {
            // Efek highlight gradasi atas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.85f),
                                Color.Transparent
                            )
                        )
                    )
            )

            // Efek Shimmer bevel dalam (Pojok kiri atas ke kanan bawah)
            Box(
                modifier = Modifier
                    .matchParentSize() // Mengisi ukuran parent secara dinamis mengikuti tinggi konten
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.25f),
                                Color.Transparent,
                                Color(0xFFD4A843).copy(alpha = 0.08f)
                            ),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                        )
                    )
            )

            // Konten utama di dalam Card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Sesuaikan padding konten dengan desain Anda
                content = content
            )
        }
    }
}