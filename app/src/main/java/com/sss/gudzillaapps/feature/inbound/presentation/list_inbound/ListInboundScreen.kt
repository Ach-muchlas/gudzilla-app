package com.sss.gudzillaapps.feature.inbound.presentation.list_inbound

import androidx.compose.runtime.Composable
import com.sss.gudzillaapps.feature.inbound.presentation.list_inbound.component.ListInboundContent

@Composable
fun ListInboundScreen(
    navBack: () -> Unit,
    navOnCreateHeader: () -> Unit,
) {
    ListInboundContent(onBackButtonClicked = navBack, onAddButtonClicked = navOnCreateHeader)
}