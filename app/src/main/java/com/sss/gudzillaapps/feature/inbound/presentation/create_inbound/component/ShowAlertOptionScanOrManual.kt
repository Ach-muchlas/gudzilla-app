package com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sss.gudzillaapps.common.component.CustomOutlineButton
import com.sss.gudzillaapps.common.component.CustomPrimaryButton
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopMedium
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.White

@Composable
fun ShowAlertOptionScanOrManual(onDismiss: () -> Unit) {
    var selectedMethod by remember { mutableStateOf("camera") }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp, bottom = 20.dp)
            ) {
                Text(
                    text = "Pilih Metode Input Barcode",
                    style = BodyPopBold,
                    modifier = Modifier
                        .padding(top = Dimens.LargeMargin)
                )

                Spacer(Modifier.height(16.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ScanMethodCard(
                        icon = Icons.Default.PhotoCamera,
                        label = "Kamera",
                        isSelected = selectedMethod == "camera",
                        modifier = Modifier.weight(1f),
                        onClick = { selectedMethod = "camera" }
                    )
                    ScanMethodCard(
                        icon = Icons.Default.Keyboard,
                        label = "Manual",
                        isSelected = selectedMethod == "manual",
                        modifier = Modifier.weight(1f),
                        onClick = {
                            selectedMethod = "manual"
                        }
                    )
                }

                Spacer(Modifier.height(20.dp))

                // Tombol kecil di kanan-kiri
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CustomOutlineButton(text = "Batal", modifier = Modifier.weight(1f)) { }
                    CustomPrimaryButton(text = "Simpan", modifier = Modifier.weight(1f)) { }
                }
            }

        }
    }
}

@Composable
fun ScanMethodCard(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val borderColor = if (isSelected) Color(0xFFA37E2D) else Color(0xFFA37E2D).copy(alpha = 0.2f)
    val bgColor = if (isSelected) Color(0xFFA37E2D).copy(alpha = 0.1f) else Color.Transparent
    val borderWidth = if (isSelected) 2.dp else 0.5.dp
    val contentColor = if (isSelected) Color(0xFFA37E2D) else Color.Gray

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(color = bgColor, shape = RoundedCornerShape(12.dp))
            .border(width = borderWidth, color = borderColor, shape = RoundedCornerShape(12.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = contentColor,
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.height(6.dp))
            Text(text = label, style = BodyPopMedium, color = contentColor)
        }
    }
}