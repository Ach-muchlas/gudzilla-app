package com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.inbound.data.model.HeaderTransactionPallet
import com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.section.ExpiryBreakdownSection
import com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.section.InboundHeaderSection
import com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.section.PurchaseOrderSection
import com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.section.StorageLocationSection
import kotlinx.coroutines.launch

@Composable
fun InboundCard(
    data: HeaderTransactionPallet,
    onCLick: () -> Unit,
) {
    val scale = remember { Animatable(1f) }
    val scope = rememberCoroutineScope()

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFFFFEFC),
        shadowElevation = 12.dp,
        tonalElevation = 2.dp,
        border = BorderStroke(1.dp, Color.DarkGray.copy(alpha = 0.2f)),
        modifier = Modifier
            .fillMaxWidth()
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
                                0.97f, spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessMedium
                                )
                            )
                        }

                        tryAwaitRelease()

                        scope.launch {
                            scale.animateTo(
                                1f, spring(Spring.DampingRatioMediumBouncy)
                            )
                        }

                        onCLick()
                    })
            }) {

        Box {

            // Highlight glossy
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.White.copy(alpha = 0.7f), Color.Transparent
                            )
                        )
                    )
            )
            Column {
                // header
                InboundHeaderSection(data.idTransaction, data.idPallet)

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StorageLocationSection(locationPallet = data.locationPallet)

                    HorizontalDivider(
                        color = Color.Gray.copy(alpha = 0.2f),
                        thickness = 1.dp,
                    )

                    PurchaseOrderSection(data.listPurchaseOrder)

                    HorizontalDivider(
                        color = Color.Gray.copy(alpha = 0.2f),
                        thickness = 1.dp,
                    )

                    ExpiryBreakdownSection(data.listPurchaseOrder)

                    Spacer(Modifier.height(Dimens.SmallMargin))
                }
            }
        }
    }
}

