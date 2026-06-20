package com.sss.gudzillaapps.feature.home.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.constanta.HomeFeatureConstant.FEATURE_PALLET
import com.sss.gudzillaapps.common.constanta.HomeFeatureConstant.FEATURE_SETTINGS
import com.sss.gudzillaapps.common.event.NavigationEvent
import com.sss.gudzillaapps.common.navigation.RouteDestination
import com.sss.gudzillaapps.feature.home.data.model.BlockNavigationType
import com.sss.gudzillaapps.feature.home.data.model.MenuData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val app: Application) : ViewModel() {

    private val _menuItems = MutableStateFlow(displayMenuBaseOnRole())
    val menuItems: StateFlow<List<MenuData>> = _menuItems

    private val _navEvent = Channel<NavigationEvent>(Channel.BUFFERED)
    val navEvent = _navEvent.receiveAsFlow()

    private val _blocked = MutableStateFlow(BlockNavigationType.NONE)
    val blocked: StateFlow<BlockNavigationType> = _blocked

    private fun displayMenuBaseOnRole(): List<MenuData> {
        val items = mutableListOf<MenuData>()

        items.add(
            MenuData(
                id = FEATURE_PALLET,
                title = app.getString(R.string.text_pallet),
                description = app.getString(R.string.text_desc_menu_pallet),
                icon = R.drawable.icon_pallet,
            )
        )

        items.add(
            MenuData(
                id = FEATURE_SETTINGS,
                title = app.getString(R.string.text_setting),
                description = app.getString(R.string.text_desc_menu_setting),
                icon = R.drawable.icon_setting,
            )
        )

        return items
    }

    fun onMenuClicked(menuData: MenuData) {
        viewModelScope.launch {
            when (menuData.id) {
                FEATURE_PALLET -> {
                    _navEvent.send(NavigationEvent.Navigate(RouteDestination.HomeToMenuPallet))
                    return@launch
                }
            }
        }
    }
}