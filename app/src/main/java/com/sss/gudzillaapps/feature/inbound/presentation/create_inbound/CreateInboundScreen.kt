package com.sss.gudzillaapps.feature.inbound.presentation.create_inbound

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalFocusManager
import com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component.CreateHeaderInboundContent

@Composable
fun CreateInboundScreen(
    onClickAddPo: () -> Unit,
) {

    val focusManager = LocalFocusManager.current

    CreateHeaderInboundContent("", {}, onClickAddPo, focusManager)
}