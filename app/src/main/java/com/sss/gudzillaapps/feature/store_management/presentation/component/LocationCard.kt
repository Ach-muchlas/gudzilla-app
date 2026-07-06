package com.sss.gudzillaapps.feature.store_management.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.component.CustomCardGradient
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.feature.store_management.presentation.component.badge.PalletBadge

@Composable
fun LocationCard(
    pallet: List<String>,
    modifier: Modifier = Modifier
) {
    CustomCardGradient(
        modifier = modifier
    ) {
        Text(
            text = "Location Good Stock",
            style = BodyPopBold.copy(color = Color(0xFF8B6210))
        )

        Spacer(modifier = Modifier.height(12.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Jarak antar kotak ke kanan
            verticalArrangement = Arrangement.spacedBy(8.dp),   // Jarak antar kotak ketika pindah baris ke bawah
            maxItemsInEachRow = Int.MAX_VALUE // Membiarkan compose menghitung otomatis berdasarkan lebar layar
        ) {
            // Lakukan perulangan untuk merender kotak kecil sesuai jumlah data yang ada
            pallet.forEach { zone ->
                PalletBadge(palletName = zone)
            }
        }
    }
}