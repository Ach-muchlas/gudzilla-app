package com.sss.gudzillaapps.feature.pallet.presentation.event

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.sss.gudzillaapps.common.data.SnackbarType
import com.sss.gudzillaapps.common.event.NavigationEvent
import com.sss.gudzillaapps.common.manager.SnackbarManager
import com.sss.gudzillaapps.common.model.SnackbarData
import com.sss.gudzillaapps.common.navigation.RouteDestination
import com.sss.gudzillaapps.feature.pallet.presentation.PalletViewModel


@Composable
fun PalletNavEventHandler(viewModel: PalletViewModel, onNavigate: (RouteDestination) -> Unit) {
    LaunchedEffect(Unit) {
        viewModel.navigationEventClick.collect { eventClicked ->
            when (eventClicked) {
                is NavigationEvent.Navigate -> onNavigate(eventClicked.destination)
                is NavigationEvent.Blocked -> SnackbarManager.showSnackbar(
                    SnackbarData(
                        eventClicked.message, SnackbarType.ERROR
                    )
                )
            }
        }
    }
}