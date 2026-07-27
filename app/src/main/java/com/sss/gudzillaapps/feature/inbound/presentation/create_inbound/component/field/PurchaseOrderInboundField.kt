package com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component.field

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.component.textfield.CustomFieldSelector
import com.sss.gudzillaapps.common.theme.BodyPopMedium
import com.sss.gudzillaapps.common.theme.Dimens


@Composable
fun PurchaseOrderInBoundField(
    onclickAddPo: () -> Unit
) {

    Text(
        text = "Pilih Purchase Order",
        style = BodyPopMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ExtraExtraSmallCornerRadius)
    )

    Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))

    CustomFieldSelector(
        textTitle = "Tambah Purchase Order",
        iconSelector = R.drawable.icon_add_orders,
        onClick = onclickAddPo
    )
}