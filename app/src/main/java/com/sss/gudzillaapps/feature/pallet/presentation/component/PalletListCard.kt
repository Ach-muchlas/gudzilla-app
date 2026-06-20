package com.sss.gudzillaapps.feature.pallet.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.theme.BodyBitterBold
import com.sss.gudzillaapps.common.theme.BodyBitterMedium
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Primary
import com.sss.gudzillaapps.common.theme.White
import com.sss.gudzillaapps.feature.home.data.model.MenuData
import kotlinx.coroutines.launch

@Composable
fun MenuListCard(
    menuData: MenuData,
    onClick: (MenuData) -> Unit = {},
) {
    val scale = remember { Animatable(1f) }
    val scope = rememberCoroutineScope()

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = White,
        shadowElevation = 12.dp,
        tonalElevation = 2.dp,
        border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.2f)),
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .graphicsLayer {
                scaleX = scale.value
                scaleY = scale.value
                ambientShadowColor = Color(0xFFB8860B)
                spotShadowColor = Color(0xFF8B6210)
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        scope.launch {
                            scale.animateTo(
                                0.97f,
                                spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessMedium
                                )
                            )
                        }

                        tryAwaitRelease()

                        scope.launch {
                            scale.animateTo(
                                1f,
                                spring(Spring.DampingRatioMediumBouncy)
                            )
                        }

                        onClick(menuData)
                    }
                )
            }
    ) {

        Box {

            // Highlight glossy
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.White.copy(alpha = 0.7f),
                                Color.Transparent
                            )
                        )
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Dimens.SmallMargin),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Icon
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(70.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(
                                Brush.radialGradient(
                                    listOf(
                                        Primary.copy(alpha = 0.15f),
                                        Color.Transparent
                                    )
                                ),
                                CircleShape
                            )
                    )

                    Image(
                        painter = painterResource(menuData.icon),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                }

                Spacer(Modifier.width(Dimens.SmallMargin))

                // Text
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = menuData.title,
                        style = BodyBitterBold.copy(
                            fontSize = 20.sp,
                            color = Primary
                        ),
                        maxLines = 1
                    )

                    Spacer(Modifier.height(2.dp))

                    Text(
                        text = menuData.description,
                        style = BodyBitterMedium.copy(
                            fontSize = 12.sp
                        ),
                        color = Color.Gray,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(Modifier.width(8.dp))

                // Next Arrow
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Primary,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}