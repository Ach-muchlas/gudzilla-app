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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.feature.store_management.presentation.component.SegmentedProgressBar

@Composable
fun TotalPalletActiveSection(modifier: Modifier = Modifier) {
    // ==================== CARD 2: ACTIVE ZONES ====================
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
                    text = "ACTIVE ZONES",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color(0xFF4A4A4A),
                        letterSpacing = 1.sp
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "12",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color(0xFF1A1A1A)
                        )
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Areas",
                        modifier = Modifier.padding(bottom = 6.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = Color(0xFF666666)
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Menggunakan Segmented Progress yang kita buat di atas
                // Contoh di gambar: 4 segmen total, 3 segmen aktif terisi emas
                SegmentedProgressBar(
                    totalSegments = 4,
                    activeSegments = 3
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "3 zones near threshold",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0xFF4A4A4A)
                    )
                )
            }

        }
    }
}