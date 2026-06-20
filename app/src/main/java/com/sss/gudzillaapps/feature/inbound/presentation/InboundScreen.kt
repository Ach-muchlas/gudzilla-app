package com.sss.gudzillaapps.feature.inbound.presentation

import androidx.compose.runtime.Composable
import com.sss.gudzillaapps.feature.inbound.presentation.component.InboundContent

@Composable
fun InboundScreen(
    navBack: () -> Unit,
) {
    InboundContent(onBackButtonClicked = navBack)
}