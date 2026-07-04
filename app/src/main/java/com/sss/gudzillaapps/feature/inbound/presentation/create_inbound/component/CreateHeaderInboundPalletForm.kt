package com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Dimens.TitleAppBar
import com.sss.gudzillaapps.common.theme.Primary
import com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component.field.PalletInboundField
import com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component.field.PurchaseOrderInBoundField

@Composable
fun CreateHeaderInboundPalletForm(
    palletId: String,
    onChangePalletID: (String) -> Unit,
    focusManager: FocusManager,
    onclickAddPo : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.MediumMargin)
    ) {
        Text(
            text = "Form create transaction inbound pallet",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = BodyPopBold.copy(color = Primary, fontSize = TitleAppBar)
        )

        Spacer(Modifier.height(Dimens.LargeMargin))

        PalletInboundField(
            textTitle = "Pallet ID",
            textHint = stringResource(R.string.text_input_pallet_id),
            value = palletId,
            leadingIcon = R.drawable.icon_add_pallet,
            onChange = onChangePalletID,
            onScanClick = {},
            focusManager = focusManager
        )
        Spacer(Modifier.height(Dimens.MediumMargin))
        PurchaseOrderInBoundField(onclickAddPo)
        Spacer(Modifier.height(Dimens.MediumMargin))
        PalletInboundField(
            textTitle = "Lokasi Storage",
            textHint = stringResource(R.string.text_input_storage),
            value = palletId,
            leadingIcon = R.drawable.icon_storage,
            onChange = onChangePalletID,
            onScanClick = {},
            focusManager = focusManager
        )

        Spacer(Modifier.height(Dimens.LargeMargin))
    }


}

