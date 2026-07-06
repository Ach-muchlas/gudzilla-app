package com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component.field

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.component.CustomTextField
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Gray
import com.sss.gudzillaapps.common.theme.Primary


@Composable
fun PurchaseOrderInBoundField(
    onclickAddPo : () -> Unit
) {

    Text(
        text = "Pilih Nomor PO",
        style = BodyPopBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ExtraExtraSmallCornerRadius)
    )

    Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))

    CustomTextField(
        value = "Tambah Purchase Order",
        onValueChange = {},
        hint = "",
        readOnly = true,
        textStyle = BodyPopBold,
        textColor = Primary,
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.icon_add_orders),
                contentDescription = "Copy IMEI",
                modifier = Modifier.size(28.dp),
                tint = Primary
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Copy IMEI",
                modifier = Modifier.size(28.dp),
                tint = Gray
            )
        },
        onClick = onclickAddPo
    )
}