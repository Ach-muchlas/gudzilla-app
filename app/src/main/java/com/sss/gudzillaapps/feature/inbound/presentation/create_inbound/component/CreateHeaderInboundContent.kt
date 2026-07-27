package com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import com.sss.gudzillaapps.common.component.button.CustomPrimaryButton
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens

@Composable
fun CreateHeaderInboundContent(
    palletId: String,
    onChangePalletID: (String) -> Unit,
    onclickAddPo: () -> Unit,
    focusManager: FocusManager,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLayout)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.MediumMargin)
                .background(BackgroundLayout),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTopBar("Header Inbound", onBackClick = {})

            Spacer(Modifier.height(Dimens.MediumMargin))

            CreateHeaderInboundPalletForm(palletId, onChangePalletID, focusManager, onclickAddPo)
        }

        CustomPrimaryButton(
            text = "Simpan", modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = Dimens.LargeMargin,
                    end = Dimens.MediumMargin,
                    start = Dimens.MediumMargin
                )
        ) { }
    }
}