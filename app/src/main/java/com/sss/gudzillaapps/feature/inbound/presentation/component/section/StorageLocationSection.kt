package com.sss.gudzillaapps.feature.inbound.presentation.component.section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopMedium
import com.sss.gudzillaapps.common.theme.Dimens


@Composable
fun StorageLocationSection(
    locationPallet: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(
                    color = Color(0xFFA37E2D).copy(alpha = 0.1f),
                    shape = RoundedCornerShape(8.dp)
                )
                .border(
                    width = 0.5.dp,
                    color = Color(0xFFA37E2D).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = Color(0xFFA37E2D),
                modifier = Modifier.size(30.dp)
            )
        }

        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)) {
            Text(
                text = "STORAGE LOCATION",
                style = BodyPopMedium.copy(
                    letterSpacing = 0.8.sp, color = Color.Black.copy(alpha = 0.75f)
                ),
            )
            Text(
                text = locationPallet,
                style = BodyPopBold.copy(fontSize = Dimens.LargeFont)
            )
        }
    }
}