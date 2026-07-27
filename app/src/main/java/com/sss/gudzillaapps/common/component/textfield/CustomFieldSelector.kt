package com.sss.gudzillaapps.common.component.textfield

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Gray
import com.sss.gudzillaapps.common.theme.Primary

@Composable
fun CustomFieldSelector(
    textTitle: String,
    @DrawableRes iconSelector: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    textColor: Color = Primary,
    borderColor: Color = Primary,
) {

    val shape = RoundedCornerShape(Dimens.SmallCornerRadius)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {

        Surface(
            modifier = Modifier
                .matchParentSize()
                .clickable { onClick() },
            shape = shape,
            color = backgroundColor,
            shadowElevation = 4.dp,
            tonalElevation = 2.dp,
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = Dimens.MediumMargin,
                        end = Dimens.MediumMargin,
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(iconSelector),
                    contentDescription = null,
                    tint = Primary,
                    modifier = Modifier.size(28.dp)
                )

                Spacer(Modifier.width(8.dp))

                Text(
                    text = textTitle,
                    style = BodyPopBold,
                    color = textColor,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Gray,
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        Canvas(
            modifier = Modifier.matchParentSize()
        ) {

            val strokeWidth = 1.5.dp.toPx()

            drawRoundRect(
                color = borderColor,
                style = Stroke(
                    width = strokeWidth,
                    pathEffect = PathEffect.dashPathEffect(
                        floatArrayOf(
                            18f, // panjang garis
                            10f  // jarak putus
                        )
                    )
                ),
                cornerRadius = CornerRadius(
                    Dimens.SmallCornerRadius.toPx(),
                    Dimens.SmallCornerRadius.toPx()
                )
            )
        }
    }
}