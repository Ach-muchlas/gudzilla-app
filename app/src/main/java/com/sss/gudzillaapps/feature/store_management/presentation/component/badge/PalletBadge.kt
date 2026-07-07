package com.sss.gudzillaapps.feature.store_management.presentation.component.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
            .height(40.dp)
            .background(
                color = Color(0xFFFFFEFC), // Menggunakan warna kartu utama agar kontras dengan background penahan
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFEFE6D5),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = palletName,
            style = BodyPopBold.copy(fontSize = 12.sp, color = Color(0xFF8B6210)),
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}