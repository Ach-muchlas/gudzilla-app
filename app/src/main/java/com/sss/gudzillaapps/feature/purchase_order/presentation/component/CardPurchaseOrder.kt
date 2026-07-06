package com.sss.gudzillaapps.feature.purchase_order.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopMedium
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Primary
import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity
import kotlinx.coroutines.launch

@Composable
fun CardPurchaseOrder(
    data: PurchaseOrderEntity,
    onClick: () -> Unit,
) {

    val scale = remember { Animatable(1f) }
    val scope = rememberCoroutineScope()

    val goldColor = Primary
    val backgroundCard = Color(0xFFFFFEFC)
    val iconBoxBg = Color(0xFFFAF3E6)

    Surface(
        shape = RoundedCornerShape(Dimens.MediumMargin),
        color = backgroundCard,
        shadowElevation = Dimens.SmallMargin,
        tonalElevation = 2.dp,
        border = BorderStroke(1.dp, goldColor.copy(alpha = 0.4f)),
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                scaleX = scale.value
                scaleY = scale.value
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        scope.launch {
                            scale.animateTo(
                                0.97f, spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessMedium
                                )
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

        Column(
            modifier = Modifier.padding(Dimens.MediumMargin)
        ) {

            // ===== Header: PO Number & Date =====
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(Dimens.SmallMargin),
                    color = iconBoxBg
                ) {
                    Text(
                        text = data.idPoInServer,
                        style = BodyPopBold.copy(color = goldColor),
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        )
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.CalendarToday,
                        contentDescription = null,
                        tint = Color.DarkGray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = data.expDate,
                        style = BodyPopMedium.copy(color = Color.DarkGray)
                    )
                }
            }

            Spacer(modifier = Modifier.height(Dimens.MediumMargin))

            // ===== Pemasok =====
            InfoRow(
                icon = Icons.Outlined.Business,
                label = "PEMASOK",
                value = data.companyName,
                iconBoxBg = iconBoxBg,
                goldColor = goldColor
            )

            Spacer(modifier = Modifier.height(Dimens.SmallMargin))

            // ===== Item =====
            InfoRow(
                icon = Icons.Outlined.Inventory2,
                label = "ITEM",
                value = data.itemName,
                iconBoxBg = iconBoxBg,
                goldColor = goldColor
            )

            Spacer(modifier = Modifier.height(Dimens.MediumMargin))

            Divider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 1.dp)

            Spacer(modifier = Modifier.height(Dimens.MediumMargin))

            // ===== Total Pesanan =====
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "TOTAL PESANAN",
                        color = Color.DarkGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = data.qtyItem,
                            color = goldColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Pcs",
                            color = Color.DarkGray,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }

            }
        }
    }
}

@Composable
private fun InfoRow(
    icon: ImageVector,
    label: String,
    value: String,
    iconBoxBg: Color,
    goldColor: Color,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(iconBoxBg)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = goldColor,
                modifier = Modifier.size(18.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = label,
                color = Color.DarkGray,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = value,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}