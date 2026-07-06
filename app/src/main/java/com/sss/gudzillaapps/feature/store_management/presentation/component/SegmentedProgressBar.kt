package com.sss.gudzillaapps.feature.store_management.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SegmentedProgressBar(
    totalSegments: Int,
    activeSegments: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = Color(0xFFB39639), // Warna emas/cokelat Gudzilla
    inactiveColor: Color = Color(0xFFEFEBE4) // Warna background abu-abu terang
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Jarak antar kotak segmen
    ) {
        for (i in 0 until totalSegments) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(12.dp) // Ketebalan progress bar
                    .background(
                        color = if (i < activeSegments) activeColor else inactiveColor,
                        shape = RoundedCornerShape(4.dp) // Ujung progress bulat halus
                    )
            )
        }
    }
}