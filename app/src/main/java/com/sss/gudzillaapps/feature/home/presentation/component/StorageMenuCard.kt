package com.sss.gudzillaapps.feature.home.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.component.ResponsiveTitleText
import kotlinx.coroutines.launch

@Composable
fun StorageMenuCard(
    percentage: Int,
    modifier: Modifier = Modifier,
    title: String = "Storage",     // Judul teks utama
    onClick: () -> Unit = {},
) {
    val scale = remember { Animatable(1f) }
    val scope = rememberCoroutineScope()

    // Hitung derajat sudut melingkar progress berdasarkan persentase input
    val sweepAngle = (percentage / 100f) * 360f

    Surface(
        shape = RoundedCornerShape(32.dp),
        color = Color(0xFFFFFEFC),
        shadowElevation = 12.dp,
        tonalElevation = 0.dp,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.87f)
            .graphicsLayer {
                scaleX = scale.value
                scaleY = scale.value
                // Menyamakan arah jatuhnya shadow dari atas kiri seperti MenuCard Anda
                ambientShadowColor = Color(0xFFB8860B)
                spotShadowColor = Color(0xFF8B6210)
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        scope.launch {
                            scale.animateTo(
                                0.96f,
                                spring(Spring.DampingRatioMediumBouncy, Spring.StiffnessMedium)
                            )
                        }
                        tryAwaitRelease()
                        scope.launch {
                            scale.animateTo(1f, spring(Spring.DampingRatioMediumBouncy))
                        }
                        onClick()
                    }
                )
            }
    ) {
        Box {
            // Efek highlight gradasi atas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
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
                    .fillMaxSize()
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

            // Penyusunan Konten Dalam Card
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {

                // Pembungkus Chart Melingkar
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(100.dp)
                ) {
                    Canvas(modifier = Modifier.size(85.dp)) {
                        // 1. Ring Background (Berbentuk lingkaran utuh dengan ujung rounded)
                        drawArc(
                            color = Color(0xECEFF8FF),
                            startAngle = 0f,
                            sweepAngle = 360f,
                            useCenter = false,
                            style = Stroke(
                                width = 12.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )
                        // 2. Ring Progress Utama (Warna Oranye dengan ujung rounded lembut)
                        drawArc(
                            color = Color(0xFFFF7A00),
                            startAngle = -90f, // Dimulai tegak lurus dari jam 12
                            sweepAngle = sweepAngle,
                            useCenter = false,
                            style = Stroke(
                                width = 12.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )
                    }

                    // Menampilkan Teks Persentase di bagian tengah dalam Canvas ring
                    Text(
                        text = "$percentage%",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E293B)
                    )
                }

                Spacer(Modifier.height(8.dp))

                // Menampilkan Judul (Menggunakan komponen ResponsiveTitleText bawaan Anda)
                ResponsiveTitleText(
                    text = title,
                )
            }
        }
    }
}