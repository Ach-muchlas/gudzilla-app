package com.sss.gudzillaapps.common.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.PeachDark
import com.sss.gudzillaapps.common.theme.PeachLight
import com.sss.gudzillaapps.common.theme.TitlePopBold

@Composable
fun CustomPrimaryButton(
    text: String,
    fontSize: TextUnit = Dimens.LargeFont,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    colors: List<Color> = listOf(
        PeachLight,
        PeachDark
    ),
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.98f else 1f,
        animationSpec = tween(100),
        label = "button_scale"
    )

    val elevation by animateDpAsState(
        targetValue = if (isPressed) 1.dp else 8.dp,
        animationSpec = tween(100),
        label = "button_elevation"
    )

    val alpha by animateFloatAsState(
        targetValue = if (enabled) 1f else 0.5f,
        label = "button_alpha"
    )

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .scale(scale)
            .alpha(alpha)
            .clickable(
                enabled = enabled && !isLoading,
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            },
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(
            width = 1.dp, color = Color.Black.copy(alpha = 0.12f)
        ),
        color = Color.Transparent,
        shadowElevation = elevation,
        tonalElevation = 0.dp
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()

                // Border tipis supaya terlihat lebih tebal
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(18.dp)
                )

                .background(
                    brush = Brush.verticalGradient(
                        colors = colors
                    ),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            if (isLoading) {

                CircularProgressIndicator(
                    modifier = Modifier.size(22.dp),
                    color = Color.White,
                    strokeWidth = 2.dp
                )

            } else {

                Text(
                    text = text,
                    color = Color.White,
                    style = TitlePopBold.copy(
                        fontSize = fontSize
                    )
                )

            }
        }
    }
}