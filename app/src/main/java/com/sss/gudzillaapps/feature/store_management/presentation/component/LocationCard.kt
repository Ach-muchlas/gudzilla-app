package com.sss.gudzillaapps.feature.store_management.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.component.card.CustomCardGradient
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopRegular
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.store_management.presentation.component.badge.PalletBadge

@Composable
fun LocationCard(
    pallet: List<String>,
    isFull: Boolean, // Status menentukan apakah penuh atau belum penuh
    availableText: String, // Contoh: "12 Slots Available"
    onManageZoneClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CustomCardGradient(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp) // Padding internal agar konten tidak menempel ke tepi luar kartu
        ) {
            // ==================== HEADER SECTION ====================
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Tengah: Title dan Available Subtitle
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Location Good Stock",
                        style = BodyPopBold.copy(fontSize = 16.sp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = availableText,
                        style = BodyPopRegular.copy(
                            fontSize = 12.sp,
                            color = Color.Gray
                        ) // Sesuaikan style regular Anda
                    )
                }

                // Kanan: Status Badge (Penuh / Belum Penuh)
                Box(
                    modifier = Modifier
                        .background(
                            color = if (isFull) Color(0xFFFEECEB) else Color(0xFFE6F4EA),
                            shape = RoundedCornerShape(14.dp)
                        )
                        .padding(Dimens.SmallMargin)
                ) {
                    Text(
                        text = if (isFull) "Penuh" else "Belum Penuh",
                        color = if (isFull) Color(0xFFD93025) else Color(0xFF137333),
                        style = BodyPopBold.copy(fontSize = Dimens.MediumFont)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ==================== BADGE CONTAINER BACKGROUND ====================
            // Bagian background khusus di belakang badge pallet agar terkelompok rapi
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF4EDE2), // Background gelap/krem penahan di belakang badge
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 6.dp, vertical = 12.dp)
            ) {
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    maxItemsInEachRow = 3 // 3 Kolom simetris untuk mengantisipasi 6 huruf
                ) {
                    pallet.forEach { zone ->
                        PalletBadge(
                            palletName = zone,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // ==================== FOOTER: MANAGE ZONE TEXT ====================
            Text(
                text = "Manage Zone",
                style = BodyPopBold.copy(
                    fontSize = 14.sp,
                    color = Color(0xFFB39639) // Warna emas khas tombol klik Gudzilla
                ),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onManageZoneClick() }
            )
        }
    }
}