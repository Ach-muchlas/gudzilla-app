package com.sss.gudzillaapps.feature.pallet.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.constanta.PalletConstant.FEATURE_INBOUND
import com.sss.gudzillaapps.common.constanta.PalletConstant.FEATURE_OUTBOUND
import com.sss.gudzillaapps.common.event.NavigationEvent
import com.sss.gudzillaapps.common.navigation.RouteDestination
import com.sss.gudzillaapps.feature.home.data.model.MenuData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PalletViewModel(private val app: Application) : ViewModel() {

    private val _menuPalletItems = MutableStateFlow(displayMenuPallet())
    val menuPalletItems: StateFlow<List<MenuData>> = _menuPalletItems

    private val _navigationEventClick = Channel<NavigationEvent>(Channel.BUFFERED)
    val navigationEventClick = _navigationEventClick.receiveAsFlow()

    private fun displayMenuPallet(): List<MenuData> {
        val items = mutableListOf<MenuData>()

        items.add(
            MenuData(
                id = FEATURE_INBOUND,
                title = "Inbound",
                description = "Fitur untuk menambah stock pada pallet.",
                icon = R.drawable.icon_pallet
            )
        )

        items.add(
            MenuData(
                id = FEATURE_OUTBOUND,
                title = "Outbound",
                description = "Fitur untuk mengurangi stock pada pallet.",
                icon = R.drawable.icon_pallet
            )
        )

        return items
    }

    fun onMenuClicked(menuData: MenuData) {
        viewModelScope.launch {
            when (menuData.id) {
                FEATURE_INBOUND -> {
                    _navigationEventClick.send(NavigationEvent.Navigate(RouteDestination.PalletToInbound))
                    return@launch
                }
            }
        }
    }
}