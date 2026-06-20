package com.sss.gudzillaapps.feature.inbound.presentation.component.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopMedium
import com.sss.gudzillaapps.common.theme.Gray
import com.sss.gudzillaapps.feature.inbound.data.model.PurchaseOrder

@Composable
fun PurchaseOrderSection(
    listPurchaseOrder: List<PurchaseOrder>,
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(
                        color = Color(0xFFA37E2D).copy(alpha = 0.1f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFFA37E2D).copy(alpha = 0.3f),
                        shape = RoundedCornerShape(8.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Receipt,
                    contentDescription = null,
                    tint = Color(0xFFA37E2D),
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "PURCHASE ORDERS", style = BodyPopMedium.copy(color = Gray)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listPurchaseOrder.forEach { po ->
                PurchaseOrderChip(po.idPo)
            }
        }
    }
}

@Composable
private fun PurchaseOrderChip(idPo: String) {
    Surface(
        shape = RoundedCornerShape(6.dp),
        color = Color(0xFFA37E2D).copy(alpha = 0.1f),
        border = BorderStroke(0.8.dp, Color(0xFFA37E2D).copy(alpha = 0.5f))
    ) {
        Text(
            text = idPo,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            style = BodyPopBold
        )
    }
}