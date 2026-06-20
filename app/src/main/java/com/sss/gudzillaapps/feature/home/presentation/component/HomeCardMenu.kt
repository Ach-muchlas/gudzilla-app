package com.sss.gudzillaapps.feature.home.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.component.ResponsiveTitleText
import com.sss.gudzillaapps.common.theme.BodyBitterMedium
import com.sss.gudzillaapps.common.theme.Primary
import com.sss.gudzillaapps.feature.home.data.model.MenuData
import kotlinx.coroutines.launch

@Composable
fun MenuCard(
    menuData: MenuData,
    onClick: (MenuData) -> Unit = {},
) {
    val scale = remember { Animatable(1f) }
    val scope = rememberCoroutineScope()

    Surface(
        shape = RoundedCornerShape(32.dp),
        color = Color(0xFFFFFEFC),
        shadowElevation = 12.dp,
        tonalElevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.87f)
            .graphicsLayer {
                scaleX = scale.value
                scaleY = scale.value
                // Arahkan cahaya shadow dari atas kiri
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
                        onClick(menuData)
                    }
                )
            }
    ) {
        Box {
            // Highlight atas
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

            // Shimmer bevel dalam — pojok kiri atas
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(
                                brush = Brush.radialGradient(
                                    colors = listOf(
                                        Primary.copy(alpha = 0.12f),
                                        Color.Transparent
                                    )
                                ),
                                shape = CircleShape
                            )
                    )

                    Image(
                        painter = painterResource(menuData.icon),
                        contentDescription = menuData.title,
                        modifier = Modifier.size(150.dp)
                    )
                }


                Spacer(Modifier.height(8.dp))

                ResponsiveTitleText(
                    text = menuData.title,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = menuData.description,
                    style = BodyBitterMedium.copy(fontSize = 12.sp),
                    color = Color.Gray,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
