package com.sss.gudzillaapps.feature.store_management.presentation.component.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.theme.BodyPopBold

@Composable
fun PalletBadge(
    palletName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = Color(0xFFF9F5EE), // Warna background krem halus khas Gudzilla
                shape = RoundedCornerShape(8.dp) // Sudut melengkung tipis untuk kotak kecil
            )
            .padding(horizontal = 12.dp, vertical = 6.dp), // Padding di dalam kotak
        contentAlignment = Alignment.Center
    ) {
        Text(
            text =palletName,
           style = BodyPopBold.copy(fontSize = 14.sp, color = Color(0xFF8B6210))
        )
    }
}