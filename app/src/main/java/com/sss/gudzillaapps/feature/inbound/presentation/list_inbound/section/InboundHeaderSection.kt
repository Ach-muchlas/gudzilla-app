package com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopMedium
import com.sss.gudzillaapps.common.theme.Dimens


@Composable
 fun InboundHeaderSection(
    idTransaction: String,
    idPallet: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFA37E2D),
                        Color(0xFFB8960F),
                    )
                ), shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {

                // Pallet Identifier Box
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color.White.copy(alpha = 0.1f),
                    border = BorderStroke(0.5.dp, Color.White.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                        Text(
                            text = "PALLET IDENTIFIER",
                            style = BodyPopMedium.copy(
                                letterSpacing = 0.8.sp, color = Color.White.copy(alpha = 0.75f)
                            ),
                        )
                        Text(
                            text = idPallet,
                            style = BodyPopBold.copy(
                                color = Color.White,
                                fontSize = Dimens.LargeFont
                            ),
                        )
                    }
                }

                // Transaction ID Box
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color.White.copy(alpha = 0.1f),
                    border = BorderStroke(0.5.dp, Color.White.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                        Text(
                            text = "TRANSACTION ID",
                            style = BodyPopMedium.copy(
                                letterSpacing = 0.8.sp, color = Color.White.copy(alpha = 0.75f)
                            ),
                        )
                        Text(
                            text = idTransaction,
                            style = BodyPopBold.copy(
                                color = Color.White,
                                fontSize = Dimens.LargeFont
                            ),
                        )
                    }
                }
            }

            // Icon Box
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(
                        Color.White.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Inbox,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

