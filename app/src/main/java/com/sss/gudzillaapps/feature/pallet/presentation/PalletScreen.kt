package com.sss.gudzillaapps.feature.pallet.presentation

import androidx.compose.runtime.Composable
import com.sss.gudzillaapps.common.navigation.RouteDestination
import com.sss.gudzillaapps.feature.pallet.presentation.component.PalletContent
import com.sss.gudzillaapps.feature.pallet.presentation.event.PalletNavEventHandler
import org.koin.androidx.compose.koinViewModel

@Composable
fun PalletScreen(
    viewModel: PalletViewModel = koinViewModel(),
    onNavigate: (RouteDestination) -> Unit,
    navBack: () -> Unit,
) {
    PalletNavEventHandler(viewModel, onNavigate)
    PalletContent(viewModel = viewModel, onBackButtonClicked = navBack)
}
