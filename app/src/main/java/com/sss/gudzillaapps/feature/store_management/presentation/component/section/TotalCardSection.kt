package com.sss.gudzillaapps.feature.store_management.presentation.component.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopMedium

@Composable
fun TotalCardSection(
    modifier: Modifier = Modifier
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
                    .matchParentSize()
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

            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "TOTAL CAPACITY",
                    style = BodyPopBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "12,480",
                        style = BodyPopBold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Slots",
                        modifier = Modifier.padding(bottom = 6.dp),
                        style = BodyPopMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                LinearProgressIndicator(
                    progress = 0.84f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    color = Color(0xFFB39639),
                    trackColor = Color(0xFFEFEBE4)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "84% Occupancy rate",
                    style = BodyPopMedium
                )
            }
        }
    }
}